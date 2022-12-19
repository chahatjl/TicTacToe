package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BoardGame {
	static ArrayList<Integer>playerPos=new ArrayList<>();
	static ArrayList<Integer>cupPos=new ArrayList<>();

	public static void main(String[] args) {
		
		char[][]board= {
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '}
				};
		
		//showBoard(board);
		
		while(true)
		{
			Scanner scan=new Scanner(System.in);
			System.out.println("enter the position where you want to enter the symbol");
			int pos=scan.nextInt();
			System.out.println(pos);
			
			while(playerPos.contains(pos)||cupPos.contains(pos))
			{
				System.out.println("position taken enter correct position");
				pos=scan.nextInt();
			}
			
			placePiece(board,pos,"person");
			String result=checkWinner();
			if(result.length()>0)
			{
				System.out.println(result);
				break;
			}
			//showBoard(board);
			
			Random rand=new Random();
			int cpuPos=rand.nextInt(9)+1;
			
			while(playerPos.contains(cpuPos)||cupPos.contains(cpuPos))
			{
				System.out.println("position taken enter correct position");
				cpuPos=scan.nextInt();
			}
			
			placePiece(board,cpuPos,"CPU");
			
			
			showBoard(board);
			
			System.out.println(checkWinner());
			
			
			if(result.length()>0)
			{
				System.out.println(result);
				break;
			}
		}
				
		
		
		}
	
	public static void showBoard(char[][]board)
	{
		for(char[] row:board)
		{
			for(char c:row)
			{
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	
	public static void placePiece(char[][] board,int pos,String user)
	{
		char symbol=' ';
		
			if(user.equals("person"))
			{
				 symbol = 'X';
				 playerPos.add(pos);
			}
			else if(user.equals("CPU"))
			{
				symbol='O';
				cupPos.add(pos);
			}
			
			switch (pos) {
			case 1:
				board[0][0]=symbol;
				break;
			case 2:
				board[0][2]=symbol;
				break;
			case 3:
				board[0][4]=symbol;
				break;
			case 4:
				board[2][0]=symbol;
				break;
			case 5:
				board[2][2]=symbol;
				break;
			case 6:
				board[2][4]=symbol;
				break;
			case 7:
				board[4][0]=symbol;
				break;
			case 8:
				board[4][2]=symbol;
				break;
			case 9:
				board[4][4]=symbol;
				break;

			default:
				break;
			}
			
		

	}
	
	public static String checkWinner()
	{
		List<Integer>toprow=Arrays.asList(1,2,3);
		List<Integer>middlerow=Arrays.asList(4,5,6);
		List<Integer>lastrow=Arrays.asList(7,8,9);
		List<Integer>firstrow=Arrays.asList(1,4,7);
		List<Integer>secondrow=Arrays.asList(2,5,8);
		List<Integer>thirdrow=Arrays.asList(3,6,9);
		List<Integer>cross1=Arrays.asList(1,5,9);
		List<Integer>cross2=Arrays.asList(3,5,7);
		
		
		List<List>winning=new ArrayList<>();
		winning.add(secondrow);
		winning.add(toprow);
		winning.add(lastrow);
		winning.add(firstrow);
		winning.add(thirdrow);
		winning.add(cross1);
		winning.add(cross2);
		winning.add(middlerow);
		
		for(List l:winning)
		{
			if(playerPos.containsAll(l))
			{
				return "congratulations you have won";
				
			}
			else if(cupPos.containsAll(l))
			{
				return "cpu have won the game :)";
			}
			else
				if(playerPos.size()+cupPos.size()==9)
					return "draw";
		}
		
		return "";
	}
	
	

}

