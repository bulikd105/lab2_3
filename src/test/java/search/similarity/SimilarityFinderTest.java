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
		
	//Test with elements in both sequences
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
		assertThat(result, is((double)2/7.0));
	}
	
	//Test without elements in both sequences
	@Test
	public void sequenceWithoutElements()
	{
		sequenceSearcherDubler = new SequenceSearcherDubler();
		similarityFinder = new SimilarityFinder(sequenceSearcherDubler);
		
		int[] seq1 = {};
		int[] seq2 = {};
		
		double expectedResult = 1;
		double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
		
		assertThat(result, is(expectedResult));
	}
	
	//Test with elements in one sequence
	@Test
	public void sequenceWithOneElementsSet()
	{
		sequenceSearcherDubler = new SequenceSearcherDubler();
		similarityFinder = new SimilarityFinder(sequenceSearcherDubler);
		
		int[] seq1 = {1,3,5,7};
		int[] seq2 = {};
		
		double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
		
		assertThat(result, is((double)0));
	}
	
	@Test
	public void sequenceReversed()
	{
		sequenceSearcherDubler = new SequenceSearcherDubler();
		similarityFinder = new SimilarityFinder(sequenceSearcherDubler);
		
		int[] seq1 = {1,3,5,7,9,11};
		int[] seq2 = {1,3,5,6};
		
		double resultOne = similarityFinder.calculateJackardSimilarity(seq1, seq2);
		double resultTwo = similarityFinder.calculateJackardSimilarity(seq2, seq1);
		
		assertThat(resultOne, is(resultTwo));
		
	}
	
}
