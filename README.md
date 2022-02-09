# webViewAlertDialog
custom alert dialog in android WebView

안드로이드 웹뷰에서 WebChromeClient 클래스의 onJsAlert, onJsConfirm 함수를 오버라이딩 해서 커스텀 다이얼로그를 띄울 때 주의점
 : dialog.setCancelable(true) 를 넣으려면 setOnCancelListener도 함께 구현
