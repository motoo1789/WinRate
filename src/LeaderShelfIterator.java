
public class LeaderShelfIterator implements Iterator{
	private LeaderShelf leaderShelf;
	private int index;

	public LeaderShelfIterator(LeaderShelf typeshelf) {
		this.leaderShelf = typeshelf;
		this.index = 0;
	}
	public boolean hasNext()
	{
		if(index < leaderShelf.getlength())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public Object next()
	{
		Leader type = leaderShelf.TypeAt(index);
		index++;
		return type;
	}

	public int returnIndex()
	{
		return index;
	}
}
