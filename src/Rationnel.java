public class Rationnel{
	private int n, a, b, result;
	private int state;
	
	public String toString(){
		if(estNul())
			return "0";
			
		if(state == 1)
			return n + "";
		else if(state == 2)
			return a + "/" + b;
		return n + " + " + a + "/" + b;
	}
	
	public Rationnel(int n){
		this.n = n;
		state = 1;
	}
	
	public Rationnel(int a, int b){
		this.a = a;
		this.b = b;
		state = 2;
	}
	
	public Rationnel(int n, int a, int b){
		this.a = a;
		this.b = b;
		this.n = n;
		state = 3;
	}
	
	public boolean estNul(){
		if(state == 1)
			return n == 0; 
		return n * b + a == 0;
	}
	
	public Rationnel inverse(){
		return new Rationnel(b, n * b + a);
	}
	
	public Rationnel ajouter(Rationnel r){
		return new Rationnel(n + r.n, a * r.b + r.a * b, b * r.b);
	}
	
	public Rationnel multiplier(Rationnel r){
		int aTmp = r.a * (a + n * b) + r.n * a * r.b;
		
		return new Rationnel(n * r.n, aTmp, b * r.b);
	}
	
	public int compareTo(Rationnel r){
		int nombre1 = n * b + a;
		int nombre2 = r.n * r.b + r.a;
		
		if(nombre1 < nombre2)
			return -1;
		else if(nombre1 == nombre2)
			return 0;
		return 1;
	}
}
