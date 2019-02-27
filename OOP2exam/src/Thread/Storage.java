package Thread;



public class Storage implements Buffer {
	int buffer=-1;

	boolean occupied= false;
	@Override
	public synchronized void store(int value) {
		// TODO Auto-generated method stub
		while(occupied){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		buffer=value;
		occupied= true;
		notifyAll();
		
		}
	}

	@Override
	public synchronized int print() {
		// TODO Auto-generated method stub
		while(!occupied)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		occupied= false;
		notifyAll();
		return buffer;
	}
	
}
