package search.dublers;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherDubler implements SequenceSearcher
{
	//Check if the key is showing in the sequence
	public SearchResult search(int key, int[] seq) 
	{
		for(int current : seq)
		{
			if(current == key)
			{
				return new SearchResultDubler(true);
			}
		}
		return new SearchResultDubler(false);
	}
}
