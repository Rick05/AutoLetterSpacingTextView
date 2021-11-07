package com.rick.autoletterspacingtextview

import android.content.Context
import android.text.SpannableString
import android.text.Spanned
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

/**
 * Author: 嘿嘿抛物线
 * Date  : 2021/11/5
 * Email : easygoingrickking@gmail.com
 * Desc  : 根据控件宽度自动设置等间距字符间隔的TextView
 */
class AutoLetterSpacingTextView : AppCompatTextView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        addLetterSpacing()
    }

    override fun setText(text: CharSequence?, type: BufferType?) {
        super.setText(text, type)
        addLetterSpacing()
    }

    /**
     * 在原先无间隔的文本中的各个字符之间插入等宽的间隔
     */
    private fun addLetterSpacing() {
        if (text.length <= 1 || paint == null) {
            return
        }

        val totalSpacing = width - paint.measureText(text.toString())
        if (totalSpacing <= 0) {
            return
        }

        // 在每两个字符之间插入间距，间距宽度 =（控件宽度 - 文本宽度）/（字符数量 - 1）
        val spannableString = SpannableString(text)
        spannableString.setSpan(
            LetterSpacingSpan(totalSpacing / ((text.length - 1))),
            0,
            text.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        // 设置新的文本
        super.setText(spannableString, BufferType.SPANNABLE)
    }
}