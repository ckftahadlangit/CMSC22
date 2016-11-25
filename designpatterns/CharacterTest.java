import java.util.*;

public class CharacterTest{
	public static void main(String[] args){
		Character king = new King();
		Character queen = new Queen();
		Character knight = new Knight();
		Character troll = new Troll();
		
		Character king1 = new King(new SwordBehavior());
		Character king2 = new King(new AxeBehavior());
		Character king3 = new King(new BowAndArrowBehavior());
		Character king4 = new King(new KnifeBehavior());
		
		Character queen1 = new Queen(new SwordBehavior());
		Character queen2 = new Queen(new AxeBehavior());
		Character queen3 = new Queen(new BowAndArrowBehavior());
		Character queen4 = new Queen(new KnifeBehavior());
		
		Character knight1 = new Knight(new SwordBehavior());
		Character knight2 = new Knight(new AxeBehavior());
		Character knight3 = new Knight(new BowAndArrowBehavior());
		Character knight4 = new Knight(new KnifeBehavior());
		
		Character troll1 = new Troll(new SwordBehavior());
		Character troll2 = new Troll(new AxeBehavior());
		Character troll3 = new Troll(new BowAndArrowBehavior());
		Character troll4 = new Troll(new KnifeBehavior());
		
		king.fight();
		queen.fight();
		knight.fight();
		troll.fight();

		System.out.println("\n*******KING*******\n");

		king1.fight();
		king2.fight();
		king3.fight();
		king4.fight();

		System.out.println("\n*******QUEEN*******\n");

		queen1.fight();
		queen2.fight();
		queen3.fight();
		queen4.fight();

		System.out.println("\n*******KNIGHT*******\n");

		knight1.fight();
		knight2.fight();
		knight3.fight();
		knight4.fight();

		System.out.println("\n*******TROLL*******\n");

		troll1.fight();
		troll2.fight();
		troll3.fight();
		troll4.fight();
	}	
}