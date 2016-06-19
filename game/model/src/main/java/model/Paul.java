package model;

import contract.IMap;
import contract.Permeability;
import contract.TypeEntity;
import contract.VisualEntity;

public class Paul extends Demon {
	public VisualEntity getVisualType(){
		return VisualEntity.PAUL;
	}
	public void move(IMap map, int x, int y) {
		if(turn != old_turn){
			int nx = 0;
			int ny = 0;
			nx = randomGenerator.nextInt(3)-1;
			if(nx==0){
				ny = randomGenerator.nextInt(3)-1;
				while( (y+ny > 0) && (y+ny < map.getHeight()) ){
					if( (map.get(x + nx, y + ny) != null)
							&& ((map.get(x + nx, y + ny).getPermeability()==Permeability.IMPERMEABLE)
							|| (map.get(x + nx, y + ny).getType()==TypeEntity.PLAYER))){
						break;
					}
					ny+=ny/Math.abs(ny);
				}
				ny = ((ny==0) ? 0 : ny/Math.abs(ny));
			}else{
				while( (x+nx > 0) && (x+nx < map.getWidth()) ){
					if( (map.get(x + nx, y + ny) != null)
							&& ((map.get(x + nx, y + ny).getPermeability()==Permeability.IMPERMEABLE)
							|| (map.get(x + nx, y + ny).getType()==TypeEntity.PLAYER))){
						break;
					}
					nx+=nx/Math.abs(nx);
				}
				nx = ((nx==0) ? 0 : nx/Math.abs(nx));
			}
			if(map.get(x + nx, y + ny)==null){
				map.move(x, y, x + nx, y + ny);
			}else if(map.get(x + nx, y + ny).getType()==TypeEntity.PLAYER){
				map.get(x + nx, y + ny).die(map);
			}
		}
	}
}
