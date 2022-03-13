package com.xl.apm

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xl.apm.ui.theme.APMTheme
import com.xl.apmkit.memory.MemoryManager


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            APMTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        Button(
                            onClick = {
                                Handler(Looper.getMainLooper()).post {
                                    Thread.sleep(1000)
                                }
                            },
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp)
                        ) {
                            Text(text = "卡顿事件监测")
                        }

                        Button(
                            onClick = {
                                Log.e("TAG", "获取内存详情:" + MemoryManager.getInstance().memoryData)
                            },
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp)
                        ) {
                            Text(text = "检查内存")
                        }

                    }
                }
            }
        }
    }


}
