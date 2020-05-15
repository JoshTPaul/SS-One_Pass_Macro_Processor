import java.io.*;
import java.util.*;
import javax.swing.*;

public class macroProcessor 
{
	static boolean expanding = false;
	static boolean endFlag = false;
	static boolean namtabFlag = false;
	static int defCount = 0;
	static int defStart=0;
	static String macroX="";
	

	protected static void define(String s, BufferedReader r) throws IOException, NullPointerException
	{
		/*
		Called when the beginning of a macro definition is recognized. 
		Make appropriate entries in DEFTAB and NAMTAB. 
		*/
		namtabFlag = true;
		FileWriter DEFTAB=new FileWriter("DEFTAB.txt", true);
		FileWriter NAMTAB=new FileWriter("NAMTAB.txt", true);
		
		String[] words = s.trim().split(" ");
		NAMTAB.write(words[0]);		//Enter Macro name into NAMTAB
		
		int level=1;
		DEFTAB.write(s+"\n");
		defCount++;
		NAMTAB.write(","+defCount);
		while(level>0)
		{
			s=getLine(r);
			if(s.startsWith("."))
				continue;
			else if(s.contains("macro")||s.contains("MACRO"))
				level++;
			
			else if(s.contains("mend")||s.contains("MEND"))
				level--;
			
			DEFTAB.write(s+"\n");
			defCount++;
		}
		NAMTAB.write(","+defCount+",");
		NAMTAB.close();
		DEFTAB.close();
	}
	
	protected static void expand(String s) throws IOException
	{
		//Called to set up the argument values in ARGTAB and expand a macro invocation statement 
		expanding=true;
		int i=0,j=0;
		String[] words = s.trim().split(" ");
		String[] args= new String[words.length-1];
		String str="";
		
		BufferedReader NAMTAB = new BufferedReader(new FileReader("NAMTAB.txt"));
		
		String[] nContents = NAMTAB.readLine().trim().split(",");
		
		while(!(words[i].equals(macroX))) {
			i++;
		}
		
		i++;
		
		for(j=i;j<words.length;j++)
		{
			str+=words[j];
		}
		
		
		FileWriter ARGTAB = new FileWriter("ARGTAB.txt", true);
		ARGTAB.write(str+"\n");
		ARGTAB.close();
		args=str.split(",");
		
		
		
		String[] t = Arrays.copyOfRange(nContents, defStart, defStart+3);
		
		
		int start=Integer.parseInt(t[1]);
		int end=Integer.parseInt(t[2]);
		
		BufferedReader DEFTAB = new BufferedReader(new FileReader("DEFTAB.txt"));
		int count=1;
		while(count!=start)
		{
			DEFTAB.readLine();
			count++;
		}
		String defContents="";
		String[] d=DEFTAB.readLine().trim().split(" ");
		String d_arg="";
		for(i=2;i<d.length;i++)
		{
			d_arg+=d[i].trim();
		}
		
		String[] originalArgs = d_arg.split(",");
		for(int a=0; a<originalArgs.length;a++)
			System.out.println(originalArgs[a]);
		String opArr="";
		
		count++;
		
		if(count==end)
			return;
		while(count<end)
		{
			opArr+=DEFTAB.readLine()+"\n";
			count++;
		}
		for(i=0;i<originalArgs.length;i++)
		{
			opArr=opArr.replaceAll(originalArgs[i], args[i]);
		}
		FileWriter OUT = new FileWriter("OUT.txt", true);
		OUT.write(opArr);
		OUT.close();
	}
	
	protected static String getLine(BufferedReader reader) throws IOException
	{
		//Get the next line to be processed
		String line=reader.readLine();
		return line;
		
	}
	
	protected static void processLine(String s, BufferedReader r) throws IOException, NullPointerException
	{
		String[] words = s.trim().split(" ");
		BufferedReader NAMTAB = new BufferedReader(new FileReader("NAMTAB.txt"));
		FileWriter OUT = new FileWriter("OUT.txt", true);
		
		if(s.startsWith("."))
		{
			OUT.write(s+"\n");
		}
		else if(s.contains("macro")||(s.contains("MACRO")))
		{
			define(s,r);
		}
		else if(namtabFlag) 
		{
			String[] nContents = NAMTAB.readLine().trim().split(",");
			
			//Never expand
			
			if(s.startsWith("."))
			{
				OUT.write(s+"\n");
			}
			else if(namtabChecker(words, nContents))
			{
				OUT.write("."+s+"\n");
				OUT.flush();
				expand(s);
			}
			else if(s.contains("end")||s.contains("END")) 
			{
				endFlag=true;
				OUT.write(s+"\n");
			}
			else
			{
				OUT.write(s+"\n");//normal o/p
			}
			
		}
		else
		{
			OUT.write(s+"\n");
			if(s.contains("end")||s.contains("END")) 
			{
				endFlag=true;
			}
		}
		OUT.close();
	}

	protected static boolean namtabChecker(String[] macroName, String[] contents)
	{
		for(int i=0;i<macroName.length;i++)
		{
			for(int j=0;j<contents.length;j+=3)
			{
				if(macroName[i].equals(contents[j]))
				{
					defStart=j;
					macroX=macroName[i];
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) 
	{
		try 
		{
			
			/*Three main data structures involved in an one-pass macro processor:
			 *  
			 * • DEFTAB • 
			 * -Stores the macro definition including macro prototype and macro body. 
			 * -Comment lines are omitted.
			 * -References to the macro instruction parameters are converted to a positional notation 
			 *  for efficiency in substituting arguments. 
			 * 
			 * • NAMTAB • 
			 * -Store macro names, which serves an index to DEFTAB contain pointers to the beginning 
			 *  and end of the definition .
			 * 
			 * • ARGTAB • 
			 * -Used during the expansion of macro invocations. 
			 * -When a macro invocation statement is encountered, the arguments are stored in this 
			 *  table according to their position in the argument list. 
			 * */
			
			FileWriter DEFTAB = new FileWriter("DEFTAB.txt");
			FileWriter NAMTAB = new FileWriter("NAMTAB.txt");
			FileWriter ARGTAB = new FileWriter("ARGTAB.txt");
			FileWriter OUT = new FileWriter("OUT.txt");
			BufferedReader reader =  new BufferedReader(new FileReader("IN.txt"));
			
			expanding=false;
			
			System.out.println("Main reached");
			while(!endFlag)
			{
				processLine(getLine(reader), reader);
			}
			macroX="";
			
			expanding = false;
			endFlag = false;
			namtabFlag = false;
			defCount = 0;
			defStart=0;
			macroX="";
			NAMTAB.close();
			DEFTAB.close();
			ARGTAB.close();
			OUT.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

}
