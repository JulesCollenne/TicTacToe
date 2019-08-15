import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*

   Ceci est la classe gérant l'affichage de la fenêtre

   Elle contient tout les éléments qui réalisent l'affichage

 */
public class Window {
    Stage primaryStage;
    Group root;
    Scene scene;
    Canvas canvas;
    GraphicsContext graphicsContext;

    int windowWidth;
    int windowHeight;


    /**
     * Constructor
     * @param primaryStage
     * @param windowWidth
     * @param windowHeight
     */
    Window(Stage primaryStage, int windowWidth, int windowHeight) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.primaryStage = primaryStage;
        this.root = new Group();
        this.scene = new Scene(root, windowWidth, windowHeight);
        this.canvas = new Canvas(windowWidth, windowHeight);
        graphicsContext = canvas.getGraphicsContext2D();
    }

    void initialize(){
        primaryStage.setTitle("TicTacToe");
        root.getChildren().add(canvas);
    }


    /**
     * Drawing functions ahead
     *
     *
     *
     */
    private void drawBoard(){
        graphicsContext.setFill(Color.BLACK);

        for(int i=1;i<3;i++) {
            double x1 = (windowWidth / 3.) * i;
            graphicsContext.strokeLine(x1,0,x1,windowHeight);
        }

        for(int i=1;i<3;i++) {
            double y1 = (windowHeight / 3.) * i;
            graphicsContext.strokeLine(0,y1,windowWidth,y1);
        }


        refresh();
    }

    void drawPieces(int[] board){
        double x,y;
        double circleWidth = (windowWidth / 3.) / 2;
        double circleHeight = (windowHeight / 3.) / 2;
        double crossSize = (windowHeight / 3.) / 2;

        graphicsContext.setLineWidth(15);

        for(int i=0;i<9;i++){
            x = (i%3) * (windowWidth / 3.) - circleWidth/2 + ((windowWidth / 3.) / 2);
            y = ((int)(i/3)) * (windowHeight / 3.) - circleHeight/2 + ((windowHeight / 3.) / 2);
            if(board[i] == 1)
                drawCircle(x,y,circleWidth,circleHeight);
            if(board[i] == 2){
                drawCross(x,y,crossSize);
            }
        }

        refresh();
    }

    void drawCircle(double x, double y, double circleWidth, double circleHeight){
        graphicsContext.setStroke(Color.RED);
        graphicsContext.strokeOval(x,y,circleWidth,circleHeight);
    }

    void drawCross(double x, double y, double crossSize){
        graphicsContext.setStroke(Color.BLUE);
        graphicsContext.strokeLine(x,y,x+crossSize,y+crossSize);
        graphicsContext.strokeLine(x,y+crossSize,x+crossSize,y);
    }

    void newGame(){
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fill();
        drawBoard();
    }



    private void refresh(){
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
