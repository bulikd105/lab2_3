package search.dublers;

import edu.iis.mto.search.SearchResult;

public class SearchResultDubler implements SearchResult
{
	//Field
	private boolean result;
	
	//Constructor
	public SearchResultDubler(boolean result)
	{
		this.result = result;
	}
	
	//Implemented functions
	public boolean isFound() 
	{
		return result;
	}

	public int getPosition() 
	{
		return 0;
	}
}
