package adil;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class diagraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double diagraph[][]=new double[26][26];
		int maxchar = 0;
	
		int maincount = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of characters");
		maxchar = sc.nextInt();
		char mes[] = new char[maxchar + 1];
		
		
		try {

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream("/Users/adilkhan/Downloads/BrownCorpus")));
			char temp[] = new char[maxchar];
			
			
			int T = 0;
			String line = new String();
			int count = 0;
			while ((line = reader.readLine()) != null) {
				line = line.toLowerCase();
				temp = line.toCharArray();
				count++;
				int length1 = temp.length;
				int startpo = 15;
				while (temp[startpo] == ' ') {
					startpo++;
				}
				for (int i = startpo; i < length1; i++) {

					if (temp[i] >= 'a' && temp[i] <= 'z') {
						mes[maincount] = temp[i];
						maincount++;
					}
					if (maincount > maxchar)
						break;

				}
				if (maincount > maxchar)
					break;
			}
			reader.close();
		} 
		catch (Exception e) {
			System.out.print(e);
			
		}
		
		
		HashMap hm = new HashMap<Character,Integer>();
		
		
		int alphabet = 97;
		
		for (int i = 0; i < 26;i ++)
		{
			hm.put((char) alphabet,i);
			alphabet ++;
		}
		
		System.out.println(hm.keySet());
		System.out.println(hm.values());
		
		
		
		for(int i=0; i<mes.length-1;i++)
		{
			diagraph[(int) hm.get(mes[i])][(int) hm.get(mes[i+1])] = diagraph[(int) hm.get(mes[i])][(int) hm.get(mes[i+1])] + 1;
		}
		
		/*
		System.out.println("Initial Diagraph matrix");
		System.out.println(" " + hm.keySet());
		for (int i =0; i<26;i++)
		{
			for(int j=0; j<26;j++)
			{
				System.out.print("  "+ diagraph[i][j]);
			}
			System.out.print("\n");
		}
		*/
		
		//System.out.println("Calculating rowsum");
		double rowsum[] = new double[26];
		
		for (int i =0; i<26;i++)
		{
			for(int j=0; j<26;j++)
			{
				rowsum[i] =  rowsum[i] + (diagraph[i][j] + 5);
			}

		}
		
	
		double sum =0;
		System.out.println("New Diagraph matrix formed after dividing by rowsum");
		//System.out.println(" " + hm.keySet());
		for (int i =0; i<26;i++)
		{
			for(int j=0; j<26;j++)
			{
				System.out.print("  " + (float) (diagraph[i][j] + 5) / rowsum[i]);
				sum = sum + (double) (diagraph[i][j] + 5) / rowsum[i];
				diagraph[i][j] = (diagraph[i][j] + 5) / rowsum[i];
				
			}
		//	System.out.print(" Sum " + sum);
			System.out.print("\n");
			sum = 0;
		}

	}

}
