package hsw.example;

import hsw.example.thread.classes.Toilet;
import hsw.example.thread.classes.ToiletThead;

public class main03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Toilet toilet = new Toilet();
		ToiletThead toiletThead1 = new ToiletThead("A", toilet);
		ToiletThead toiletThead2 = new ToiletThead("B", toilet);
		ToiletThead toiletThead3 = new ToiletThead("C", toilet);
		
		toiletThead1.start();
		toiletThead2.start();
		toiletThead3.start();
	}

}