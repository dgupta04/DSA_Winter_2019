class dhruv {
	static int x ;
	dhruv( int i ){
		x = i;
	}
}

class Main {
	static int add( int a ){
		return a+5;
	}

	static dhruv Add( dhruv a){
		int u = dhruv.x;
		return new dhruv((u + 5));
	}

	public static void main(String[] args) {
		int u = 10;
		dhruv t = new dhruv( 10 );
		int q = add(u);
			System.out.println( t.x );
		dhruv r = Add( t );
		System.out.println( q );
		System.out.println( u );
	
		System.out.println( r.x );
		System.out.println( t.x );

	}
}