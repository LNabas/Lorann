package model;

import contract.IMap;
import contract.TypeEntity;
import contract.VisualEntity;
/** Demon class
 * @author Maxence, Gregory
 */
public class Charles extends Demon {
	public VisualEntity getVisualType(){
			return VisualEntity.CHARLES;
		}
	
	
	
	public void move(IMap map, int x, int y) {
		if(turn != old_turn){
			boolean found = false;
			int nx = 0;
			int ny = 0;
			int radius = 5;
			for(nx = -radius; nx<radius && !found; nx++){
				for(ny = -radius; ny<radius && !found; ny++){
					int nnx = nx+x;
					int nny = ny+y;
					if(nnx>0 && nnx<map.getWidth() && nny>0 && nny<map.getHeight()
						&&map.get(x + nx, y + ny) != null
						&&map.get(x + nx, y + ny).getType()==TypeEntity.KEY){
						found = true;		
					}
				}
			}
			nx=(nx==0) ? 0 : nx/Math.abs(nx);
			ny=(ny==0) ? 0 : ny/Math.abs(ny);
			if(found){
				if(map.get(x + nx, y + ny) != null &&map.get(x + nx, y + ny).getType()==TypeEntity.PLAYER){
					map.get(x + nx, y + ny).die(map);
				}else if(map.get(x + nx, y + ny) == null){
					map.move(x, y, x + nx, y + ny);
				}else if(map.get(x, y + ny) == null){
					map.move(x, y, x, y + ny);
				}else if(map.get(x + nx, y) == null){
					map.move(x, y, x + nx, y);
				}else{
					super.move(map, x, y);
				}
			}else{
				super.move(map, x, y);
			}
		}
	}
	
	
	
	
	
	
}
