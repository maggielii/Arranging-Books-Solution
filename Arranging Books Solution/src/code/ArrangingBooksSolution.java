package code;

import java.util.Scanner;

public class ArrangingBooksSolution {

	public static void main(String[] args) {

		//LMSMMSLLSSSMSSMLLSSMMSLLLSM
		
		Scanner input = new Scanner(System.in);
		String books = input.next();
		char[] array = books.toCharArray();
		
		int large = 0, medium = 0, small = 0;
		
		for(int x = 0; x < array.length; x++)
		{
			if(array[x] == 'L')			
				large++;
			else if(array[x] == 'M') 	
				medium++;
			else
				small++;
		}
	
		int mInLSection = 0, sInLSection = 0;
		
		for(int x = 0; x < large; x++) //no brackets because one line, each automatically attach
			if(array[x] == 'M')
				mInLSection++;
			else if(array[x] == 'S')
				sInLSection++;
		
		int lInMSection = 0, sInMSection = 0;
		
		for(int x = large; x < large + medium; x++)
			if(array[x] == 'L')
				lInMSection++;
			else if(array[x] == 'S')
				sInMSection++;
		
		int lInSSection = 0, mInSSection = 0;
		
		for(int x = large + medium; x < array.length; x++)
			if(array[x] == 'L')
				lInSSection++;
			else if(array[x] == 'M')
				mInSSection++;
		
		int swaps = 0;
		
		while( sInLSection > 0 && lInSSection > 0)
		{
			sInLSection--;
			lInSSection--;
			swaps++;
		}
		
		while( mInLSection > 0 && lInMSection > 0)
		{
			mInLSection--;
			lInMSection--;
			swaps++;
		}
		
		while( sInMSection > 0 && mInSSection > 0)
		{
			sInMSection--;
			mInSSection--;
			swaps++;
		}
		
		swaps += mInLSection * 2;
		swaps += sInLSection * 2;
		
		System.out.println(swaps);
			
	}

}
