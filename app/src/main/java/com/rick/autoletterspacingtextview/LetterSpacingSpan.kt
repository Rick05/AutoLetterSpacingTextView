package com.rick.autoletterspacingtextview

import android.graphics.Canvas
import android.graphics.Paint
import android.text.style.ReplacementSpan


/**
 * Author: 嘿嘿抛物线
 * Date  : 2021/11/6
 * Email : easygoingrickking@gmail.com
 * Desc  : 在字符串的各个字符之间插入间隔
 */
class LetterSpacingSpan(private val mSpacingPx: Float) : ReplacementSpan() {

    override fun getSize(
        paint: Paint, text: CharSequence?,
        start: Int, end: Int, fm: Paint.FontMetricsInt?
    ): Int {
        return ((paint.measureText(text, start, end) + mSpacingPx * (end - start - 1)).toInt())
    }

    override fun draw(
        canvas: Canvas, text: CharSequence?,
        start: Int, end: Int, x: Float, top: Int, y: Int,
        bottom: Int, paint: Paint
    ) {
        text ?: return
        var dx = x
        for (i in start until end) {
            canvas.drawText(text, i, i + 1, dx, y.toFloat(), paint)
            dx += paint.measureText(text, i, i + 1) + mSpacingPx
        }
    }
}