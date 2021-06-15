package controller;

import model.Dish;
import view.View;

public class GameController {
	
	private Dish dishTree;
	private final int YES = 0;
	private final int NO = 1;
	
	public GameController() {
		initDishTree();
	}

	public Dish getDishTree() {
		return dishTree;
	}

	public void setDishTree(Dish dishTree) {
		this.dishTree = dishTree;
	}

	private void initDishTree() {

		Dish lasanha = new Dish();
		lasanha.setName("Lasanha");
		lasanha.setAccept(null);
		lasanha.setNotAccept(null);

		Dish bolo = new Dish();
		bolo.setName("Bolo de Chocolate");
		bolo.setAccept(null);
		bolo.setNotAccept(null);

		Dish massa = new Dish();
		massa.setName("massa");
		massa.setAccept(lasanha);
		massa.setNotAccept(bolo);
		
		setDishTree(massa);
	}

	public void startActivity() {
		nextDish(dishTree);
	}

	public Dish nextDish(Dish current) {
		int choice = View.showPaneIsDishQuestion(current.getName());
		Dish newDish = null;
		switch (choice) {
		case YES:
			if (current.getAccept() == null) {
				View.showPaneVictoryMessage();
				newDish = null;
			} else {
				newDish = nextDish(current.getAccept());
				if (newDish != null) {
					current.setAccept(newDish);
					newDish = null;
				}
			}
			break;

		case NO:
			if (current.getNotAccept() == null) {
				newDish = createNewDish (current);
			} else {
				newDish = nextDish(current.getNotAccept());
				if (newDish != null) {
					current.setNotAccept(newDish);
					newDish = null;
				}
			}
			break;
		}
		return newDish;
	}
	
	
	public Dish createNewDish (Dish current) {
		String newDishName = View.showPaneDishNameQuestion();
		
		if(newDishName != null){
			newDishName =  newDishName.trim();
			if(!newDishName.equals("")){
				Dish userNewDish = new Dish();
				userNewDish.setName(newDishName);
				userNewDish.setAccept(null);
				userNewDish.setNotAccept(null);
				
				String differentDishName = View.showPaneDishDifferenceQuestion(newDishName, current.getName());
			
				Dish questionDifferentDish = new Dish();
				questionDifferentDish.setName(differentDishName);
				questionDifferentDish.setAccept(userNewDish);
				questionDifferentDish.setNotAccept(current);
				
				return questionDifferentDish;
			}
		}
		return null;
	}

}
