package contract;

public interface IMap {
	public IEntity get(int x, int y);
	public int getWidth();
	public int getHeight();
	public IEntity getPlayer();
	public void kill(int x, int y);
	public void move(int origin_x, int origin_y, int new_x, int new_y);
	public void reload();
}
