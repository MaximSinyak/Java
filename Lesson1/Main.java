package ru.geekbrains.Lesson1;

public class Main {

    public static void main(String[] args) {
		Object[] partArray = new Object[6];
		partArray[0] = new Human("Ivan", 100, 1);
		partArray[1] = new Cat("Pushok", 500, 2);
		partArray[2] = new Robot("Robo", 300, 5);
		partArray[3] = new Human("Petr", 500, 6);
		partArray[4] = new Cat("Rizhik", 400, 7);
		partArray[5] = new Robot("Android", 600, 4);


		Object[] barArray = new Object[5];
		barArray[0] = new Racetrack(50);
		barArray[1] = new Wall(3);
		barArray[2] = new Racetrack(300);
		barArray[3] = new Wall(5);
		barArray[4] = new Racetrack(400);


		for (Object i : partArray) {
			for (Object j : barArray) {
				if (i instanceof Human) {
					if (j instanceof Racetrack) {
						if (!((Racetrack) j).action(((Human) i).getName(), ((Human) i).getRun(), ((Racetrack) j).getDistanse())){
							System.out.println(((Human) i).getName() + " не прошел препятствия");
							break;
						}
					}
					if (j instanceof Wall) {
						if (!((Wall) j).action(((Human) i).getName(), ((Human) i).getJump(), ((Wall) j).getHeight())){
							System.out.println(((Human) i).getName() + " не прошел препятствия");
							break;
						}
					}

				}
				if (i instanceof  Cat){
					if (j instanceof Racetrack) {
						if (!((Racetrack) j).action(((Cat) i).getName(), ((Cat) i).getRun(), ((Racetrack) j).getDistanse())){
							System.out.println(((Cat) i).getName() + " не прошел препятствия");
							break;
						}
					}
					if (j instanceof Wall) {
						if (!((Wall) j).action(((Cat) i).getName(), ((Cat) i).getJump(), ((Wall) j).getHeight())){
							System.out.println(((Cat) i).getName() + " не прошел препятствия");
							break;
						}
					}
				}

				if (i instanceof  Robot){
					if (j instanceof Racetrack) {
						if (!((Racetrack) j).action(((Robot) i).getName(), ((Robot) i).getRun(), ((Racetrack) j).getDistanse())){
							System.out.println(((Robot) i).getName() + " не прошел препятствия");
							break;
						}
					}
					if (j instanceof Wall) {
						if (!((Wall) j).action(((Robot) i).getName(), ((Robot) i).getJump(), ((Wall) j).getHeight())){
							System.out.println(((Robot) i).getName() + " не прошел препятствия");
							break;
						}
					}
				}

			}

		}

	}
}
