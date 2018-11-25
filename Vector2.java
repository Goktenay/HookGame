class Vector2 {
	// Vektörün x ve y deðerlerini tutar.
	public float x;
	public float y;
	private static double DegToRad = Math.PI/180;

	public Vector2() {
		this(0, 0);
	}

	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}


	public static Vector2 substract(Vector2 v, Vector2 k) {
		return new Vector2(v.x - k.x, v.y - k.y);
	}

	public static Vector2 add(Vector2 v, Vector2 k) {
		return new Vector2(v.x + k.x, v.y + k.y);
	}

	// Vektörün yönünü tersine çevirir.
	public void invert() {
		x *= -1;
		y *= -1;
	}

	public Vector2 getInverted() {
		return new Vector2(-x, -y);
	}

	// Vektörün büyüklüðünü döndürür.
	public float magnitude() {
		return (float) Math.sqrt(x * x + y * y);
	}

	// Büyüklüðün karesini döndürür (Daha az iþlem).
	public float squareMagnitude() {
		return x * x + y * y;
	}

	// Bu vektörü birim vektöre çevirir.
	public void normalize() {
		float l = magnitude();

		// Eðer büyüklük 0 ise bir sayýyý 0'a bölmeye çalýþýrken hata alýrýz.
		if (l > 0) {
			x /= l;
			y /= l;
		}
	}


	public Vector2  getNormalized() {
		float l = magnitude();

		// Eðer büyüklük 0 ise bir sayýyý 0'a bölmeye çalýþýrken hata alýrýz.
		if (l > 0)
		return new Vector2(x/l, y/l);

		return null;
	}

	// Vektörü Verilen sayý ile skalar çarpma iþlemi yapar.
	public void multiply(float k) {
		x *= k;
		y *= k;
	}

	public static Vector2 multiply(Vector2 p, float k) {
		return new Vector2(p.x * k, p.y * k);
	}

	// Vektörü Verilen skalar sayýya böler.
	public void divide(float k) {
		// 0'a bölüp bölmediðimizi kontrol et.
		if (k != 0) {
			this.x /= k;
			this.y /= k;
		}
	}

	// Verilen vektör ile toplar.
	public void add(Vector2 k) {
		this.x += k.x;
		this.y += k.y;
	}

	// Verilen vektörü çýkartýr.
	public void subtract(Vector2 k) {
		this.x -= k.x;
		this.y -= k.y;
	}

	// Vektörü skale edilmiþ vektör ile toplar.
	public void addScaledVector(Vector2 v, float scale) {
		this.x += v.x * scale;
		this.y += v.y * scale;

	}



	public Vector2 getScaledVector(Vector2 v, float scale) {
		return new Vector2((v.x * scale) + x, (v.y * scale) + y);

	}

	public Vector2 getCopy()
	{
		return new Vector2(x,y);
	}

	// Bu vektöre verilen vektörle component product iþlemi yapar.
	public void componentProductUpdate(Vector2 v) {
		this.x *= v.x;
		this.y *= v.y;
	}

	// Bu vektörün dot product'ýný döndürür. (Scalar product olarak da geçer.)
	public float scalarProduct(Vector2 v) {
		return this.x * v.x + this.y * v.y;
	}


	public Vector2 turn90Degree() {
		return new Vector2(-y, x);
	}

	public Vector2 turnMinus90Degree() {
		return new Vector2(y, -x);
	}

	public static double calculateAngle(Vector2 v)
	{
		double temp = Math.toDegrees( Math.atan2(-v.y, v.x));

		if ( temp < 0)
		{
			temp += 360;
		}

		return temp;

	}



	    public static Vector2 Rotate(Vector2 v, double degrees)
	    {
	        return Vector2.RotateRadians(v ,degrees * DegToRad);
	    }

	    public static Vector2 RotateRadians(Vector2 v, double radians)
	    {
	        float ca = (float) Math.cos(radians);
	        float sa = (float) Math.sin(radians);
	        return new Vector2(ca*v.x- sa*v.y, sa*v.x + ca*v.y);
	    }

}