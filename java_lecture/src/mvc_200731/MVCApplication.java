package mvc_200731;

public class MVCApplication {

	public static void main(String[] args) {
		ModelPeople model = retrievePeople();
		ViewPeople view = new ViewPeople();

		ControllerPeople controller = new ControllerPeople(model, view);
		controller.updateView();

		controller.setPeopleName("Lee");
		controller.setPeopleHobby("Playing Soccer");
		controller.updateView();
	}

	private static ModelPeople retrievePeople() {
		ModelPeople model = new ModelPeople();
		model.setName("Kim");
		model.setHobby("Watching Baseball Games");
		return model;
	}
}
