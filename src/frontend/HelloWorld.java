package frontend;

import backend.BackendController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Toggle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Pair;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import javafx.scene.control.TextArea;
//import javafx.fxml.FXMLLoader;



//yessir
public class HelloWorld extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException{

        GridPane root = new GridPane();


        Scene scene = new Scene(root, 1250, 800);

        Scene scene2 = new Scene(new Group());
        scene2.getStylesheets().add(getClass().getResource("stylesheets/stylesheet1.css").toExternalForm());
        Rectangle rect = new Rectangle(1250,800);
        rect.setLayoutX(0);
        rect.setLayoutY(0);
        rect.getStyleClass().add("my-rect");
        ((Group)scene2.getRoot()).getChildren().add(rect);

        Rectangle rect2 = new Rectangle(1250,150);
        rect2.setLayoutX(0);
        rect2.setLayoutY(0);
        rect2.getStyleClass().add("my-rect2");
        ((Group)scene2.getRoot()).getChildren().add(rect2);

        Rectangle rect3 = new Rectangle(1250,20);
        rect3.setLayoutX(0);
        rect3.setLayoutY(150);
        rect3.getStyleClass().add("my-rect3");
        ((Group)scene2.getRoot()).getChildren().add(rect3);

        Image image = new Image(new FileInputStream("src/frontend/f.gif"));
        ImageView iv = new ImageView();




        primaryStage.setTitle("Sardine");
        primaryStage.setScene(scene2);
        primaryStage.show();

        Text t = new Text();
        t.setText("Sardine");
        t.setLayoutX(440);
        t.setLayoutY(105);
        t.getStyleClass().add("title");
        //t.setFill(Color.WHITE);
        ((Group)scene2.getRoot()).getChildren().add(t);

        ToggleButton btn2 = new ToggleButton();
        btn2.setText("Retrieval Method 1");
        btn2.setMinSize(500, 85);
        btn2.setLayoutX(18);
        btn2.setLayoutY(185);
        btn2.getStyleClass().add("button1");

        ((Group) scene2.getRoot()).getChildren().add(btn2);

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            boolean dataType = true;
            @Override
            public void handle(ActionEvent event) {

                if(dataType) {
                    btn2.setText("Retrieval Method 2");
                }
                else{
                    btn2.setText("Retrieval Method 1");
                }
                dataType ^= true;
            }
        });

        Text dataMethod = new Text();
        dataMethod.setText("Data Method");
        dataMethod.setLayoutX(205);
        dataMethod.setLayoutY(335);
        dataMethod.getStyleClass().add("datamethod");
        //t.setFill(Color.WHITE);
        ((Group)scene2.getRoot()).getChildren().add(dataMethod);

        ToggleGroup TheGroup = new ToggleGroup();
        ToggleButton button_1a = new ToggleButton("option 1a");
        ToggleButton button_1b = new ToggleButton("option 1b");
        ToggleButton button_2 = new ToggleButton("option 2");
        ToggleButton button_3 = new ToggleButton("option 3");
        button_1a.setToggleGroup(TheGroup);
        button_2.setToggleGroup(TheGroup);
        button_3.setToggleGroup(TheGroup);
        button_1a.setLayoutX(18);
        button_1a.setLayoutY(350);
        button_2.setLayoutX(18);
        button_2.setLayoutY(450);
        button_3.setLayoutX(18);
        button_3.setLayoutY(550);
        button_1a.setMinSize(500, 85);
        button_2.setMinSize(500, 85);
        button_3.setMinSize(500, 85);
        button_1a.getStyleClass().add("button1");
        button_2.getStyleClass().add("button1");
        button_3.getStyleClass().add("button1");
        ((Group) scene2.getRoot()).getChildren().addAll(button_1a, button_2, button_3);


        Button btn = new Button();
        btn.setText("Fetch Data");
        btn.setMinSize(500, 85);
        btn.setLayoutX(18);
        btn.setLayoutY(700);
        btn.getStyleClass().add("button1");
        ((Group)scene2.getRoot()).getChildren().add(btn);
        btn.setOnAction(e -> {
            // Shaddy's List Function
            BackendController bc = new BackendController();
            bc.fetchStocks();
            System.out.println(btn2.isSelected());
            ArrayList<Pair<String,Long>> goombi = bc.volumeQuery(btn2.isSelected());

            ArrayList<Text> googoo = new ArrayList<>();
            for(int i = 0; i < 5; i++) {
                Text name = new Text();
                Text val = new Text();
                name.setX(600);
                name.setY(i*40 +300);
                name.setText(goombi.get(i).getKey());
                val.setX(900);
                val.setY(i*40 + 300);
                String temp = "" + goombi.get(i).getValue();
                val.setText(temp);
                googoo.add(name);
                googoo.add(val);
            }


            Button stock1 = new Button();
            stock1.setText("1. " + goombi.get(0).getKey());
            stock1.setMinSize(200, 75);
            stock1.setLayoutX(600);
            stock1.setLayoutY(220);
            stock1.getStyleClass().add("stockbox");
            ((Group) scene2.getRoot()).getChildren().add(stock1);

            Button stock2 = new Button();
            stock2.setText("2. " + goombi.get(1).getKey());
            stock2.setMinSize(200, 75);
            stock2.setLayoutX(600);
            stock2.setLayoutY(335);
            stock2.getStyleClass().add("stockbox");
            ((Group) scene2.getRoot()).getChildren().add(stock2);

            Button stock3 = new Button();
            stock3.setText("3. " + goombi.get(2).getKey());
            stock3.setMinSize(200, 75);
            stock3.setLayoutX(600);
            stock3.setLayoutY(450);
            stock3.getStyleClass().add("stockbox");
            ((Group) scene2.getRoot()).getChildren().add(stock3);

            Button stock4 = new Button();
            stock4.setText("4. " + goombi.get(3).getKey());
            stock4.setMinSize(200, 75);
            stock4.setLayoutX(600);
            stock4.setLayoutY(565);
            stock4.getStyleClass().add("stockbox");
            ((Group) scene2.getRoot()).getChildren().add(stock4);

            Button stock5 = new Button();
            stock5.setText("5. " + goombi.get(4).getKey());
            stock5.setMinSize(200, 75);
            stock5.setLayoutX(600);
            stock5.setLayoutY(680);
            stock5.getStyleClass().add("stockbox");
            ((Group) scene2.getRoot()).getChildren().add(stock5);



            //Set the scene
            for(int i = 0; i < googoo.size(); i++) {
                ((Group) scene2.getRoot()).getChildren().add(googoo.get(i));
            }
        });


    }
    public static void main(String[] args) {
        launch(args);
    }
}