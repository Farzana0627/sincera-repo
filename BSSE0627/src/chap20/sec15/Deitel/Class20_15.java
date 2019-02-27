package chap20.sec15.Deitel;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Class20_15 {
	public static void main(String[] args) {
		Map<String, Color> color= new HashMap<>();
		color.put("Black", Color.BLACK);
		color.put("Blue", Color.BLUE);
		color.put("Red", Color.RED);
		color.put("Yellow", Color.YELLOW);
		color.put("Green", Color.GREEN);
		color.put("Pink", Color.PINK);
		color.put("Gray", Color.GRAY);
		color.put("White", Color.WHITE);
		color.put("Orange", Color.ORANGE);
		color.put("Cyan", Color.CYAN);
		color.put("Dark_Gray", Color.DARK_GRAY);
		color.put("Magenta", Color.MAGENTA);
		color.put("light_Gray", Color.LIGHT_GRAY);
		
		for(Map.Entry<String, Color> m: color.entrySet())
			System.out.println(m.getKey()+" "+m.getValue());
		
		System.out.println("Enter a color name:");
		Scanner scr= new Scanner(System.in);
		String s = scr.next();
		scr.close();
		System.out.println(color.get(s));
		
	}
}
