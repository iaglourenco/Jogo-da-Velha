package com.iaglourenco.oldgame;

import java.util.Scanner;

/**
 *
 * @author 15610116
 */
public class OldGame {

    
    
    static int tabuleiro[][]={	{-1,-1,-1},
                       			{-1,-1,-1},
                       			{-1,-1,-1}};
	private static Scanner input;
	private static Scanner input2;
    
    public static void main(String[] args) {
        
        System.out.printf("\t\t.:Jogo da Velha:.\n");
        int win=-99,contaJogadas=0;
        while(win != 1 || win != 2 ){//ate que um dos players ganhe e ate que a qtd de jogadas seja menor q 8
        	
        	
        	printTabuleiro();
        	int rtn1=player1(); //guarda o retorno do que aconteceu com a jogada do player1
        	
        	while(rtn1 == -1 && contaJogadas<9) {
            //jogada invalida
        	printTabuleiro();	
            System.out.println("Jogada Invalida");
            rtn1=player1();
            }
        
        	
        	if(rtn1 == 0){
        		contaJogadas++; // atualiza as jogadas feitas
        		 if(contaJogadas>8) 
          		{
          			win=-99;
          			break;
          		}
            	
            }if(rtn1 == 1) {
            	//youwin
            	win=rtn1;
            	break;
            }
            
            
        	printTabuleiro();
            int rtn2=player2();//guarda o retorno do que aconteceu com a jogada do player2
            
            while( rtn2 == -1 && contaJogadas<9){
                //jogada invalida
            	printTabuleiro();
            	System.out.println("Jogada Invalida");
                rtn2=player2();
            }
            
            if(rtn2 == 0){
            	contaJogadas++; // atualiza as jogadas feitas
           	 if(contaJogadas>8) 
       		{
       			win=-99;
       			break;
       		}
         	
                	
                }if(rtn2 == 2) {
                	//youwin
                	win=rtn2;
                	break;
                }
                
               
               
        }
        if(win==1) 
        	System.out.println("Jogador 1 ganhou!!");
        else if(win ==2)
        	System.out.println("Jogador 2 ganhou!!");
        else
        	System.out.println("Que pena :( Deu empate!");
        
        printTabuleiro();
       
        
        
       
    }
    
    public static void printTabuleiro() { 
    	
    	 for(int i=0;i<3;i++) {
     		for(int j=0;j<3;j++) {
     			
     			switch (tabuleiro[i][j]) {
				case -1://vazio
					System.out.printf("| |");
					break;
				case 1://player1
					System.out.printf("|X|");
					break;
				case 2://player2
					System.out.printf("|O|");
					break;
				
				}
     		
     		}
     		System.out.println();
         }
         
    	
    }
    
    public static int verificaVitoria(int player) { 
    	
    	if(tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[0][0] == tabuleiro[2][2] && tabuleiro[0][0] == player) 
    		return 1; //diagonal principal
    	
    	if(tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[0][2] == tabuleiro[2][0] && tabuleiro[0][2] == player) 
    		return 1; //diagonal secundaria

    	
    	for(int i=0;i<3;i++) {
    		
    		if(tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][0] == tabuleiro[i][2] && tabuleiro[i][0] == player) 
        		return 1; //horizontais
        	
    	}
    	
    	for(int i=0;i<3;i++) {
    		
    		if(tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[0][i] == tabuleiro[2][i] && tabuleiro[0][i] == player) 
        		return 1; //verticais
        	
    	}
    	
    	
    	
    	
    	return 0;
    }
    
    public static int jogar(int posicaoX,int posicaoY,int player){//valida a posicao de jogada e a faz
        
        if(posicaoX < 0 || posicaoX > 8)
            return -1; //posicao invalida
        
        if(posicaoY < 0 || posicaoY > 8)
            return -1; //posicao invalida
        
        if(tabuleiro[posicaoX][posicaoY] != -1)
        	return -1; //posicao ocupada
        
        if(player==1){
        	tabuleiro[posicaoX][posicaoY] = 1;
        }else {
        	tabuleiro[posicaoX][posicaoY] = 2;
        }
        
  

        return verificaVitoria(player);
    }
    
    public static int player1(){//transforma o numero em coordenadas
        
        int posY=-1,posX=-1;
        input = new Scanner(System.in);
        System.out.printf("JOGADOR 1: Digite uma posicao:\n");
        int posicao=input.nextInt();
        
        if(posicao>=0 && posicao<=2)
        {
        	posX=posicao-posicao;
        	posY=posicao;
        }else if(posicao >= 3 && posicao <= 5 ) 
        {
        	posX=posicao-(posicao-1);
        	if(posicao==3){
        		posY=posY-posY;
        	}
        	posY=posicao-3;
        }else if(posicao >= 6 && posicao <= 8)
        {
        	posX=posicao-(posicao-2);
        	if(posicao == 6){
        		posY=posY-posY;
        	}
        	posY=posicao-6;
        }
        
        
        
        return jogar(posX,posY,1);
    }
    
    public static int player2(){//eq player1()
            
        int posX=-1,posY=-1;
        input2 = new Scanner(System.in);
        System.out.printf("JOGADOR 2: Digite uma posicao:\n");
        int posicao=input2.nextInt();
        
        if(posicao>=0 && posicao<=2)
        {
        	posX=posicao-posicao;
        	posY=posicao;
        }else if(posicao >= 3 && posicao <= 5 ) 
        {
        	posX=posicao-(posicao-1);
        	if(posicao==3){
        		posY=posY-posY;
        	}
        	posY=posicao-3;
        }else if(posicao >= 6 && posicao <= 8)
        {
        	posX=posicao-(posicao-2);
        	if(posicao == 6){
        		posY=posY-posY;
        	}
        	posY=posicao-6;
        }
        
        int res=jogar(posX,posY,2);
        
        if(res==1)
        	return res+1;//youwin
  
        return res;// jogada ok ou jogada invalida
    
    }
    
}