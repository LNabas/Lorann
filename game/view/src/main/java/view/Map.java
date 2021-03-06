package view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import contract.IMap;
import contract.VisualEntity;
/**
 * Graphical Map
 * @author Doc0160
 *
 */
public class Map extends GraphicsBuilder{
	private IMap map;
	BufferedImage sol;
	BufferedImage skull;
	BufferedImage hbone;
	BufferedImage vbone;
	BufferedImage lorann;
	BufferedImage lorannu;
	BufferedImage lorannd;
	BufferedImage lorannl;
	BufferedImage lorannur;
	BufferedImage lorannul;
	BufferedImage lorannr;
	BufferedImage loranndr;
	BufferedImage loranndl;
	BufferedImage fireball;
	BufferedImage fireball1;
	BufferedImage fireball2;
	BufferedImage fireball3;
	BufferedImage fireball4;
	BufferedImage key;
	BufferedImage paul;
	BufferedImage henry;
	BufferedImage pierre;
	BufferedImage charles;
	BufferedImage dc;
	BufferedImage don;
	BufferedImage purse;
	public Map(RessourcesLoader r, IMap map) {
		super(r);
		this.map = map;
		sol = ressources.getSpriteCopy("Sol");
		//
		skull = ressources.getSpriteCopy("Sol");
		skull.getGraphics().drawImage(ressources.getSprite("Skull"), 0, 0, null);
		hbone = ressources.getSpriteCopy("Sol");
		hbone.getGraphics().drawImage(ressources.getSprite("HBone"), 0, 0, null);
		vbone = ressources.getSpriteCopy("Sol");
		vbone.getGraphics().drawImage(ressources.getSprite("VBone"), 0, 0, null);
		key = ressources.getSpriteCopy("Sol");
		key.getGraphics().drawImage(ressources.getSprite("Key"), 0, 0, null);
		//
		lorann = ressources.getSpriteCopy("Sol");
		lorann.getGraphics().drawImage(ressources.getSprite("Lorann"), 0, 0, null);
		lorannu = ressources.getSpriteCopy("Sol");
		lorannu.getGraphics().drawImage(ressources.getSprite("LorannU"), 0, 0, null);
		lorannd = ressources.getSpriteCopy("Sol");
		lorannd.getGraphics().drawImage(ressources.getSprite("LorannD"), 0, 0, null);
		loranndr = ressources.getSpriteCopy("Sol");
		loranndr.getGraphics().drawImage(ressources.getSprite("LorannDR"), 0, 0, null);
		loranndl = ressources.getSpriteCopy("Sol");
		loranndl.getGraphics().drawImage(ressources.getSprite("LorannDL"), 0, 0, null);
		lorannl = ressources.getSpriteCopy("Sol");
		lorannl.getGraphics().drawImage(ressources.getSprite("LorannL"), 0, 0, null);
		lorannur = ressources.getSpriteCopy("Sol");
		lorannur.getGraphics().drawImage(ressources.getSprite("LorannUR"), 0, 0, null);
		lorannul = ressources.getSpriteCopy("Sol");
		lorannul.getGraphics().drawImage(ressources.getSprite("LorannUL"), 0, 0, null);
		lorannr = ressources.getSpriteCopy("Sol");
		lorannr.getGraphics().drawImage(ressources.getSprite("LorannR"), 0, 0, null);
		//
		fireball = ressources.getSpriteCopy("Sol");
		fireball.getGraphics().drawImage(ressources.getSprite("Fireball"), 0, 0, null);
		fireball1 = ressources.getSpriteCopy("Sol");
		fireball1.getGraphics().drawImage(ressources.getSprite("Fireball1"), 0, 0, null);
		fireball2 = ressources.getSpriteCopy("Sol");
		fireball2.getGraphics().drawImage(ressources.getSprite("Fireball2"), 0, 0, null);
		fireball3 = ressources.getSpriteCopy("Sol");
		fireball3.getGraphics().drawImage(ressources.getSprite("Fireball3"), 0, 0, null);
		fireball4 = ressources.getSpriteCopy("Sol");
		fireball4.getGraphics().drawImage(ressources.getSprite("Fireball4"), 0, 0, null);
		//
		paul = ressources.getSpriteCopy("Sol");
		paul.getGraphics().drawImage(ressources.getSprite("Paul"), 0, 0, null);
		henry = ressources.getSpriteCopy("Sol");
		henry.getGraphics().drawImage(ressources.getSprite("Henry"), 0, 0, null);
		pierre = ressources.getSpriteCopy("Sol");
		pierre.getGraphics().drawImage(ressources.getSprite("Pierre"), 0, 0, null);
		charles = ressources.getSpriteCopy("Sol");
		charles.getGraphics().drawImage(ressources.getSprite("Charles"), 0, 0, null);
		//
		purse = ressources.getSpriteCopy("Sol");
		purse.getGraphics().drawImage(ressources.getSprite("Purse"), 0, 0, null);
		//
		dc = ressources.getSpriteCopy("Sol");
		dc.getGraphics().drawImage(ressources.getSprite("DC"), 0, 0, null);
		don = ressources.getSpriteCopy("Sol");
		don.getGraphics().drawImage(ressources.getSprite("DO"), 0, 0, null);
	}
	/**
	 * @param m
	 */
	public void setMap(IMap m){
		map=m;
		need_redraw=true;
	}
	public Image getImage() {
		if(need_redraw){
			need_redraw=false;
			setSize(paul.getWidth()*map.getWidth(), paul.getHeight()*map.getHeight());
			for(int i = 0; i < map.getWidth(); i++){
				for(int j = 0; j < map.getHeight(); j++){
					VisualEntity t = VisualEntity.FLOOR;
					if(map.get(i, j) != null){
						t = map.get(i, j).getVisualType();
						if(t==null){
							t = VisualEntity.FLOOR;
						}
					}
					switch(t){
					case CHARLES:
						drawImage(charles, i*charles.getWidth(), j*charles.getHeight());
						break;
					case PIERRE:
						drawImage(pierre, i*pierre.getWidth(), j*pierre.getHeight());
						break;
					case HENRY:
						drawImage(henry, i*henry.getWidth(), j*henry.getHeight());
						break;
					case PAUL:
						drawImage(paul, i*paul.getWidth(), j*paul.getHeight());
						break;
					case PLAYER:
						drawImage(lorann, i*lorann.getWidth(), j*lorann.getHeight());
						break;
					case PLAYER_U:
						drawImage(lorannu, i*lorannu.getWidth(), j*lorannu.getHeight());
						break;
					case PLAYER_UR:
						drawImage(lorannur, i*lorannur.getWidth(), j*lorannur.getHeight());
						break;
					case PLAYER_UL:
						drawImage(lorannul, i*lorannul.getWidth(), j*lorannul.getHeight());
						break;
					case PLAYER_D:
						drawImage(lorannd, i*lorannd.getWidth(), j*lorannd.getHeight());
						break;
					case PLAYER_DR:
						drawImage(loranndr, i*loranndr.getWidth(), j*loranndr.getHeight());
						break;
					case PLAYER_DL:
						drawImage(loranndl, i*loranndl.getWidth(), j*loranndl.getHeight());
						break;
					case PLAYER_L:
						drawImage(lorannl, i*lorannl.getWidth(), j*lorannl.getHeight());
						break;
					case PLAYER_R:
						drawImage(lorannr, i*lorannr.getWidth(), j*lorannr.getHeight());
						break;
					case ITEMGOOD:
						drawImage(purse, i*purse.getWidth(), j*purse.getHeight());
						break;
					case KEY:
						drawImage(key, i*key.getWidth(), j*key.getHeight());
						break;
					case SKULL:
						drawImage(skull, i*skull.getWidth(), j*skull.getHeight());
						break;
					case HORIZONTAL_BONE:
						drawImage(hbone, i*hbone.getWidth(), j*hbone.getHeight());
						break;
					case VERTICAL_BONE:
						drawImage(vbone, i*vbone.getWidth(), j*vbone.getHeight());
						break;
					case FLOOR:
						drawImage(sol, i*sol.getWidth(), j*sol.getHeight());
						break;
					case FIREBALL:
						drawImage(fireball, i*fireball.getWidth(), j*fireball.getHeight());
						break;
					case FIREBALL1:
						drawImage(fireball1, i*fireball1.getWidth(), j*fireball1.getHeight());
						break;
					case FIREBALL2:
						drawImage(fireball2, i*fireball2.getWidth(), j*fireball2.getHeight());
						break;
					case FIREBALL3:
						drawImage(fireball3, i*fireball3.getWidth(), j*fireball3.getHeight());
						break;
					case FIREBALL4:
						drawImage(fireball4, i*fireball4.getWidth(), j*fireball4.getHeight());
						break;
					case DOOR_OPEN:
						drawImage(don, i*don.getWidth(), j*don.getHeight());
						break;
					case DOOR_CLOSED:
						drawImage(dc, i*dc.getWidth(), j*dc.getHeight());
						break;
					default:
						drawImage(sol, i*sol.getWidth(), j*sol.getHeight());
						System.out.println(t);
						break;
					}
				}
			}
		}
		return bufferImage;
	}
}
