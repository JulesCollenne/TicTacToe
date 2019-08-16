import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Player extends Application {
    private int playerNum;
    private boolean isPlaying;
    private Window window;
    private int board[];

    Player(Window window, int board[], int playerNum){
        this.playerNum = playerNum;
        isPlaying = false;
        this.window = window;
        this.board = board;
    }

    void play(){
        isPlaying = true;
        window.canvas.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
    }

    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            System.out.println("Hello World");//TODO
            if(window.chooseSquare(window.getSquare(e.getX(),e.getY()), playerNum) != -1)
                isPlaying = false;
        }
    };

    void won(){

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
