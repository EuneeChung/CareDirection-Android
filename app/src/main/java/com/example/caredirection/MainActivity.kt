package com.example.caredirection


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listData = ArrayList<BarEntry>()
        listData.add(BarEntry(0f, 55f))
        listData.add(BarEntry(1f, 20f))
        listData.add(BarEntry(2f,60f))
        listData.add(BarEntry(3f,80f))
        listData.add(BarEntry(4f,100f))
        listData.add(BarEntry(5f,40f))
        listData.add(BarEntry(6f, 55f))
        listData.add(BarEntry(7f, 20f))
        listData.add(BarEntry(8f,60f))
        listData.add(BarEntry(9f,80f))
        listData.add(BarEntry(10f,120f))


        val listData2 = ArrayList<BarEntry>()
        listData.add(BarEntry(0f, 55f))
        listData.add(BarEntry(1f, 20f))
        listData.add(BarEntry(2f,60f))
        listData.add(BarEntry(3f,80f))
        listData.add(BarEntry(4f,100f))
        listData.add(BarEntry(5f,40f))


       /*
       val lineDataSet1 = BarDataSet ( listData,"회사 1")
        lineDataSet1.color = R.color.colorPrimaryDark
        //lineDataSet1.setDrawValues ​​(false)
        lineDataSet1.setAxisDependency (YAxis.AxisDependency.LEFT)

        val lineDataSet2 = BarDataSet(listData2, "회사 2")
        lineDataSet2.color = Color.BLUE
        //lineDataSet1.setDrawValues ​​(false)
        lineDataSet2.setAxisDependency (YAxis.AxisDependency.LEFT)

        val lineDataSets = arrayListOf (lineDataSet1, lineDataSet2)
        val listData1 = ArrayList<BarEntry>()
        listData1.addAll(0,listData)
        listData1.addAll(1,list2Data)


        //initLineChart()
        */
        //val data = BarData(lineDataSet2)
        //chart.data = lineDataSets
        initLineChart()
        setChart(listData)



    }

    private fun initLineChart() {

        val xAxis = chart.xAxis
        xAxis.setDrawLabels(false)
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.granularity = 1f
        xAxis.setDrawGridLines(false)
        xAxis.setDrawAxisLine(false)

        val rightYAxis = chart.axisRight
        rightYAxis.isEnabled=false
        rightYAxis.mAxisMinimum=0f
        rightYAxis.mAxisMaximum=120f
        /*
        rightYAxis.granularity= 40f // 라벨 간격 조정
        rightYAxis.setDrawLabels(false)
        rightYAxis.setDrawGridLines(false)
        rightYAxis.setDrawAxisLine(false)
        */
        val ll1 = LimitLine(100f, "Maximum Limit")
        ll1.lineWidth = 4f
        ll1.enableDashedLine(50f, 20f, 0f)
        //ll1.enableDashedLine(선의 길이, 선사이의 공간, 0f)
        //TODO phase는 무엇인가?
        ll1.labelPosition = LimitLine.LimitLabelPosition.RIGHT_TOP
        ll1.textSize = 10f

        val ll2 = LimitLine(30f, "Minimum Limit")
        ll2.lineWidth = 4f
        ll2.enableDashedLine(50f, 20f, 0f)
        //ll1.enableDashedLine(선의 길이, 선사이의 공간, 0f)
        //TODO phase는 무엇인가?
        ll2.labelPosition = LimitLine.LimitLabelPosition.RIGHT_TOP
        ll2.textSize = 10f

        val leftYAxis = chart.axisLeft
        leftYAxis.setAxisMaximum(120f)
        leftYAxis.setAxisMinimum(0f)
        //leftYAxis.mAxisMinimum=0f
        //leftYAxis.mAxisMaximum=120f
        leftYAxis.granularity= 20f //라벨 써주는 간격 조정
        leftYAxis.setDrawLabels(true)
        leftYAxis.setDrawGridLines(false)
        leftYAxis.setDrawAxisLine(false)

        leftYAxis.addLimitLine(ll1)  // 상한선 그리기
        leftYAxis.addLimitLine(ll2)



    }

    private fun setChart(listData: ArrayList<BarEntry>) {
        val dataSet = BarDataSet(listData, getString(R.string.app_name))

        val listColor = ArrayList<Int>()
        listColor.add(ContextCompat.getColor(this, R.color.colorPrimaryDark))
        listColor.add(ContextCompat.getColor(this, R.color.colorAccent))
        listColor.add(ContextCompat.getColor(this, R.color.colorPrimary))
        dataSet.colors = listColor
        dataSet.valueTextColor = ContextCompat.getColor(this, android.R.color.black)

        val lineData = BarData(dataSet)
        chart.data = lineData
        chart.setFitBars(true)
        chart.setTouchEnabled(true)//됨
        chart.isHorizontalScrollBarEnabled=true
        //chart.isDragXEnabled=true
        chart.isDragDecelerationEnabled=true
      // chart.setDragXEnabled(true)
        //chart.setHorizontalScrollBarEnabled(true)
        chart.isDoubleTapToZoomEnabled=true//두번터치하고 스크롤은 됨
        chart.isDragXEnabled=true
        chart.setVisibleXRange(3f,8f)
        chart.animateY(1000) //세로축 에니메이션
       // chart.data = lineData
        chart.invalidate()


    }
}