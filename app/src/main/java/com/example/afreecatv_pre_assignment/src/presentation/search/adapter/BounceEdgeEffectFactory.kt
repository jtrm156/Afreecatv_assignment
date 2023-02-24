package com.example.afreecatv_pre_assignment.src.presentation.search.adapter

import android.graphics.Canvas
import android.widget.EdgeEffect
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import androidx.recyclerview.widget.RecyclerView

private const val OVERSCROLL_TRANSLATION_MAGNITUDE = 0.2f

private const val FLING_TRANSLATION_MAGNITUDE = 0.5f

class BounceEdgeEffectFactory(height : Int) : RecyclerView.EdgeEffectFactory() {
    private var mHeight : Int = 0

    init {
        this.mHeight = height
    }

    override fun createEdgeEffect(recyclerView: RecyclerView, direction: Int): EdgeEffect {
        return object : EdgeEffect(recyclerView.context) {
            // 오버 스크롤 효과 후 항목을 다시 가져오는 데 사용되는 이 RecyclerView의 [SpringAnimation]에 대한 참조입니다.
            var translationAnim: SpringAnimation? = null

            override fun onPull(deltaDistance: Float) {
                super.onPull(deltaDistance)
                handlePull(deltaDistance)
            }

            override fun onPull(deltaDistance: Float, displacement: Float) {
                super.onPull(deltaDistance, displacement)
                handlePull(deltaDistance)
            }

            // 목록이 손가락으로 스크롤되는 동안 모든 터치 이벤트에서 호출
            private fun handlePull(deltaDistance: Float) {
                // recyclerView를 거리로 변환
                val sign = if (direction == DIRECTION_BOTTOM) -1 else 1
                val translationYDelta = sign * recyclerView.height * deltaDistance * OVERSCROLL_TRANSLATION_MAGNITUDE
                recyclerView.translationY += translationYDelta

                translationAnim?.cancel()
            }

            override fun onRelease() {
                super.onRelease()
                // 손가락을 들어 올립니다. 번역을 휴식 상태로 되돌리려면 애니메이션을 시작
                if (recyclerView.translationY != 0f) {
                    translationAnim = createAnim()?.also { it.start() }
                }
            }

            override fun onAbsorb(velocity: Int) {
                super.onAbsorb(velocity)
                // 목록이 가장자리에 도달
                val sign = if (direction == DIRECTION_BOTTOM) -1 else 1
                val translationVelocity = sign * velocity * FLING_TRANSLATION_MAGNITUDE
                translationAnim?.cancel()
                translationAnim = createAnim().setStartVelocity(translationVelocity)?.also { it.start() }
            }

            override fun draw(canvas: Canvas?): Boolean {
                // 일반적인 가장자리 효과를 칠하지 마십시오.
                return false
            }

            override fun isFinished(): Boolean {
                // 이것이 없으면 향후 onAbsorb() 호출을 건너뜁니다.
                return translationAnim?.isRunning?.not() ?: true
            }

            private fun createAnim() = SpringAnimation(recyclerView, SpringAnimation.TRANSLATION_Y)
                .setSpring(SpringForce()
                    .setFinalPosition(0f)
                    .setDampingRatio(SpringForce.DAMPING_RATIO_MEDIUM_BOUNCY)
                    .setStiffness(SpringForce.STIFFNESS_LOW)
                )
        }
    }
}