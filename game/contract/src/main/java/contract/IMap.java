package contract;

public interface IMap {
	public IEntity get(int x, int y);
	public int getWidth();
	public int getHeight();
	public IEntity getPlayer();
}
