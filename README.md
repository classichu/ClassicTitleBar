# ClassicTitleBar
自定义标题栏 ClassicTitleBar CustomTitleBar


标题栏
![1](https://github.com/classichu/ClassicTitleBar/blob/master/screenshots/screenshot.png)

menu样式菜单
![2](https://github.com/classichu/ClassicTitleBar/blob/master/screenshots/screenshot2.png)

自定义View样式菜单
![3](https://github.com/classichu/ClassicTitleBar/blob/master/screenshots/screenshot3.png)

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.classichu:ClassicDialogView:1.0.0'
	}



attrs

        classic_leftAndRightTextColor
		左侧和右侧文字颜色
        classic_centerTextColor
		标题文字颜色

        classic_leftAndRightTextSize
		左侧和右侧文字大小
        classic_centerTextSize
		标题文字大小

        classic_leftAndRightPadding 
		左侧和右侧文字内边距
        classic_centerPadding
		标题文字内边距


        classic_leftMaxWidth
        classic_rightMaxWidth
        classic_centerMaxWidth
		最大宽度

        classic_leftText
        classic_rightText
        classic_centerText
		分别是左右、标题文字

        classic_leftDrawable
        classic_rightDrawable
		classic_centerDrawable
		分别是左右、标题图标

        classic_leftDrawableExchange
        classic_rightDrawableExchange
		classic_centerDrawableExchange
		分别是左右、标题图标是否和文字交换位置

        classic_leftDrawablePadding
        classic_rightDrawablePadding
		classic_centerDrawablePadding
		分别是左右、标题图标的内边距