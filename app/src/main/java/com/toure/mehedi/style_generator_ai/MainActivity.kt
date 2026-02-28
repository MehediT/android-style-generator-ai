package com.toure.mehedi.style_generator_ai

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberPermissionState
import com.toure.mehedi.style_generator_ai.navigation.NavGraph
import com.toure.mehedi.style_generator_ai.ui.AppViewModel
import com.toure.mehedi.style_generator_ai.ui.MainScaffold
import com.toure.mehedi.style_generator_ai.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val appViewModel: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        appViewModel.ensureSession()
        setContent {
            AppTheme {
                PermissionHandler{
                    AppContent(appViewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
private fun PermissionHandler(
    content: @Composable () -> Unit
) {
    val permissionState = rememberPermissionState(
        permission = Manifest.permission.INTERNET
    )

    LaunchedEffect(Unit) {
        if (permissionState.status != PermissionStatus.Granted) {
            permissionState.launchPermissionRequest()
        }
    }
}

@Composable
private fun AppContent(
    viewModel : AppViewModel
) {
    val navController = rememberNavController()
    MainScaffold(
        navController = navController,
        viewModel = viewModel,
    ) { paddingValues ->
        NavGraph(
            navController = navController,
            paddingValues = paddingValues
        )
    }
}