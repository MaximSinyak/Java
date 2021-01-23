package ru.geekbrains.lesson_7;

public class Main {

    public static void main(String[] args) {

	Cat[] catsArray = new Cat[5];
	catsArray[0] = new Cat("Barsik", 5);
	catsArray[1] = new Cat("Murzik", 4);
	catsArray[2] = new Cat("Rizhik", 3);
	catsArray[3] = new Cat("Vaska", 4);
	catsArray[4] = new Cat("Kuza", 7);

	Plate[] platesArray = new Plate[5];
	platesArray[0] = new Plate(1);
	platesArray[1] = new Plate(8);
	platesArray[2] = new Plate(7);
	platesArray[3] = new Plate(6);
	platesArray[4] = new Plate(10);

	info(catsArray, platesArray);
	eat(catsArray, platesArray);
	info(catsArray, platesArray);
	addFood(platesArray, 3, 6);
	info(catsArray, platesArray);

    }

    public static void eat(Cat[] catsArray, Plate[] platesArray){
		for (Plate plate : platesArray){
			for (Cat cat : catsArray){
				if (!(cat.getSatiety())){
					if ((plate.getFood() - cat.getAppetite()) >= 0) {
						cat.setSatiety(true);
					}
					plate.setFood(plate.getFood() - cat.getAppetite());

				}
			}
		}
	}

	public static void info(Cat[] catsArray, Plate[] platesArray){
		for (Plate i : platesArray){
			i.info();
		}
		for (Cat i : catsArray){
			i.info();
		}
	}

	public static void addFood(Plate[] platesArray, int i, int food){
    	platesArray[i].setFood(platesArray[i].getFood() + food);
	}

}
