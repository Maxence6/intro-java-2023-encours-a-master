package fr.pgah;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import org.graalvm.compiler.nodes.extended.OSRMonitorEnterNode;

public class Intro extends ApplicationAdapter {
  SpriteBatch batch; // variables (SpriteBatch : Type de la variable | batch : nom de la variable)
  Texture img; // variables (Si le type commence par une majuscule, c'est un type objet | Si le type commence par une minuscule, c'est un type primitif)
  int x;
  int y;
  int hauteurFenetre;
  int hauteurImg;
  int directionEnY; // 0 pour monter et 1 pour descendre
  int boolean on Monte 1;

  @Override
  public void create() { // méthode (create : nom de la méthode)
    batch = new SpriteBatch(); // méthode (= : affectation | new : instanciation)
    img = new Texture("sio.jpg"); // méthode
    x = 0;
    y = 0;
    hauteurImg = img.getHeight();
    hauteurFenetre = Gdx.graphics.getHeight();
    directionEnY = 0;
  }

  @Override
  public void render() {
    reinitialiserBackgroud(); // corps de la méthode
    testerBordures();
    programmeX();
    testerDirection();
    dessin();
  }

  private void dessin() {
    batch.begin(); // corps de la méthode (begin : appel de méthode)
    batch.draw(img, x, y); // corps de la méthode
    batch.end(); // corps de la méthode
  }

  private void testerDirection() {
    if (onMonte == true) {
      y = y + 1; // incrémentation
    } else {
      y = y - 1; //décrémentation
    }
  }

  private void programmeX() {
    x = x + 1;
  }

  private void testerBordures() {
    // if (Tape la bordure haute)
    if(y + hauteurImg == hauteurFenetre) {
      directionEnY = 1;
    }
    // if (Tape la bordure basse)
    if(y == 0) {
      directionEnY = 0;
    }
  }

  private void reinitialiserBackgroud() {
    ScreenUtils.clear(1, 0, 0, 1);
  }
}
  