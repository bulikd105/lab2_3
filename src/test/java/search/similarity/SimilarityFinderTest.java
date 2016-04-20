package search.similarity;

import org.junit.Test;
import edu.iis.mto.similarity.SimilarityFinder;
import search.dublers.SequenceSearcherDubler;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimilarityFinderTest 
{
	//Add new sequence searcher
	SequenceSearcherDubler sequenceSearcherDubler;
	
	//Add new similarity finder
	SimilarityFinder similarityFinder;
	
	@Test
	public void sequenceWithElements()
	{
		sequenceSearcherDubler = new SequenceSearcherDubler();
		similarityFinder = new SimilarityFinder(sequenceSearcherDubler);
		//Add two sets of number 
		int[] seq1 = {1,3,5,7,9,11};
		int[] seq2 = {1,3,6};
		
		//Calculate result
		double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
		
		//Run test
		assertThat(result, is(2/7.0));
	}
	
	@Test
	public void sequenceWithoutElements()
	{
		//Add two sets of number 
		int[] seq1 = {};
		int[] seq2 = {};
		
		//Calculate result
		double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
		
		//Run test
		assertThat(result, is((double)1));
	}
}
