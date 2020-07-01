/*
 * Copyright 2020 ZUP IT SERVICOS EM TECNOLOGIA E INOVACAO SA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.zup.beagle.sample.components

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.AnimatedVectorDrawable
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast
import br.com.zup.beagle.android.utils.dp
import br.com.zup.beagle.sample.R
import kotlinx.android.synthetic.main.custom_page_indicator.view.*

typealias OnIndexChanged = (index: Int) -> Unit

@SuppressLint("NewApi")
class CustomPageIndicatorView(context: Context) : RelativeLayout(context) {

    private var selectedItem = 0
    private var pagesCount = 0
    private var onIndexChanged: OnIndexChanged? = null

    init {
        inflate(context, R.layout.custom_page_indicator, this)
        bind()
    }

    private fun bind() {
        var newIndex: Int

        tvSkip.setOnClickListener {
            openScreen()
        }

        tvContinue.setOnClickListener {
            newIndex = selectedItem + 1
            if (selectedItem == pagesCount - 1) {
                openScreen()
            } else {
                onIndexChanged?.invoke(newIndex)
            }
        }
    }

    private fun openScreen() {
        Toast.makeText(context, "Open Screen", Toast.LENGTH_SHORT).show()
    }

    fun setCount(pages: Int) {
        for (i in 0 until pages) {
            val dot = ImageView(context)
            dot.id = i

            if (i == selectedItem) {
                dot.setImageResource(R.drawable.left_right)
            } else {
                dot.setImageResource(R.drawable.right_left_reverse)
            }

            llPageIndicator.addView(dot)

            val dotParams = dot.layoutParams as LinearLayout.LayoutParams
            val horizontalMargin = 2.dp()
            val verticalMargin = 2.dp()

            dotParams.setMargins(horizontalMargin, verticalMargin, horizontalMargin, verticalMargin)
            dot.layoutParams = dotParams

            (dot.drawable as AnimatedVectorDrawable).start()
        }
        pagesCount = pages
    }

    private fun getImageViewByIndex(index: Int): ImageView {
        return (llPageIndicator.getChildAt(index) as ImageView)
    }

    private fun handleDotsAnimation(newIndex: Int) {
        if (newIndex > selectedItem) {
            (getImageViewByIndex(newIndex).apply {
                setImageResource(R.drawable.right_left)
            }.drawable as AnimatedVectorDrawable).start()
            (getImageViewByIndex(selectedItem).apply {
                setImageResource(R.drawable.left_right_reverse)
            }.drawable as AnimatedVectorDrawable).start()
        } else {
            (getImageViewByIndex(newIndex).apply {
                setImageResource(R.drawable.left_right)
            }.drawable as AnimatedVectorDrawable).start()
            (getImageViewByIndex(selectedItem).apply {
                setImageResource(R.drawable.right_left_reverse)
            }.drawable as AnimatedVectorDrawable).start()
        }
    }

    private fun handleSkipVisibility() {
        if (selectedItem == pagesCount - 1) {
            tvSkip.visibility = INVISIBLE
        } else {
            tvSkip.visibility = VISIBLE
        }
    }

    fun setCurrentIndex(newIndex: Int) {
        handleDotsAnimation(newIndex)
        selectedItem = newIndex
        handleSkipVisibility()
    }

    fun setIndexChangedListener(onIndexChanged: OnIndexChanged) {
        this.onIndexChanged = onIndexChanged
    }

    fun setSkipName(skipName: String) {
        tvSkip.text = skipName
    }

    fun setContinueName(continueName: String) {
        tvContinue.text = continueName
    }
}
