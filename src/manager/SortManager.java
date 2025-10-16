package manager;

public class SortManager
{
	private String fileName;
	private char compareType;
	private char sortType;

	public SortManager(String[] args)
	{
		
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		for (String arg : args)
		{
			if (arg.startsWith("-f") || arg.startsWith("-F"))
			{
				fileName = arg.substring(2);
				
			}
			else if(arg.startsWith("-t") || arg.startsWith("-T"))
			{
				compareType = arg.substring(2).charAt(0);
			}
			else if(arg.startsWith("-s") || arg.startsWith("-S"))
			{
				sortType = arg.substring(3).charAt(0);
			}
		}
		System.out.println("File Name is" + fileName);
		System.out.println("Compare Type is" + compareType);
		System.out.println("Sort Type is" + sortType);
		// TODO Auto-generated constructor stub
	}

}
