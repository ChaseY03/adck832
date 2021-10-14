String gameState;
boolean ended;

ArrayList<Circle> circles;

int time = 10;
int score = 0;
int cps;

void setup()
{
  //canvas size
  size(1280, 720);
  //sets player on start screen
  gameState = "Start";

  //adds a new circle into the array
  circles = new ArrayList<Circle>();
  circles.add(new Circle());
}

void draw()
{
  //resets background
  clean();
  if (gameState == "Start")
  {
    //splash screen
    gameStart();
  } else if (gameState == "Play")
  {
    //playing screen
    gamePlay();
  } else if (gameState == "ShowScore") {
    //ending screen
    showScore();
  }
  //shows circles
  for (int i = circles.size()-1; i >= 0; i--) {
    Circle circle = circles.get(i);
    circle.display();
  }
}

void mousePressed()
{
  //only adds score and creates/removes circles if the mouse click is left and the game is not ended
  if (mouseButton == LEFT && ended == false) {
    for (int i = circles.size()-1; i >= 0; i--) {
      circles.get(i);
      circles.add(new Circle());
      circles.remove(i);
      score++;
    }
  }
}
void clean()
{
  background(254, 244, 232);
}

void gameStart()
{
  textAlign(CENTER);
  textSize(40);
  fill(#0EC196);
  text("CPS tester \nClick the screen to begin", width/2, height/2);

  //click to interact followthrough
  if (mousePressed == true)
  {
    gameState = "Play";
  }
}
void gamePlay()
{
  ended = false;
  fill(0);
  //count down timer
  text(time, width/2, height/2);
  if (frameCount % 60 == 0 && time > 0)
  {
    //removes 1s of the time each time till time hits 0
    time --;
  }
  if (time == 0)
  {
    //end game if the timer hits 0, go to the ending screen state
    fill(255, 0, 0);
    text("GAME OVER", width/2, height*0.7);
    showScore();
  }
}
void showScore()
{
  fill(0);
  text("Your clicks per second:", width/2, 60);
  //clicks per second = user score/ time passed
  cps = score/10;
  println(score);
  text(cps, width/2, 100);
  ended = true;

  //retry button
  fill(0, 255, 0);
  rectMode(CENTER);
  rect(width/2, height/2+200, 180, 60);
  fill(255);
  textSize(40);
  text("RETRY", width/2, height/2+215);
  //button click region
  float buttonEdgeX1 = width/2-90;
  float buttonEdgeX2 = width/2+90;
  float buttonEdgeY1 = height/2+170;
  float buttonEdgeY2 = height/2+230;

  //if region is hit, reset the game
  if (mousePressed == true && mouseX > buttonEdgeX1
    && mouseX < buttonEdgeX2 && mouseY > buttonEdgeY1
    && mouseY < buttonEdgeY2)
  {
    gameState = "Play";
    time = 10;
    score = 0;
  }
}
/*void restart()
 {
 
 }*/
