
public abstract class AbstractSave {
	protected abstract void open();
	protected abstract void print();
	protected abstract void close();
	public void save() {
		open();
		print();
		close();

	}
}
