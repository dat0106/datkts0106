package de.vogella.eclipsedemocamp.android.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

public class DrawingView extends View {

	private Paint paint;
	private Path path;

	public DrawingView(Context context) {
		super(context);
		paint = new Paint();
		path = new Path();
		paint.setAntiAlias(true);
		paint.setColor(Color.WHITE);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeJoin(Paint.Join.ROUND);
		paint.setStrokeWidth(5f);

	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawPath(path, paint);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int action = event.getAction();
		float x = event.getX();
		float y = event.getY();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			path.moveTo(x, y);
			break;
		case MotionEvent.ACTION_MOVE:
			path.lineTo(x, y);
			invalidate();
		default:
			break;
		}
		return true;
	}
}
