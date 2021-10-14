class Circle
{
  float radius;
  color colour;
  PVector pos;

  Circle()
  {
    //sets random spawn position for circle
    pos = new PVector(random(width), random(height));
    radius = 50;
    //sets random colour on each circle created
    colour = color(random(255), random(255), random(255));
  }
  
  void display()
{
  noStroke();
  fill(colour);
  circle(pos.x,pos.y,radius*2);
}
}
