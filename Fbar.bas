B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=8.3
@EndOfDesignText@
'Custom View class 
#Event: ButtonClick (Tag As String)

#DesignerProperty: Key: Back, DisplayName: Back button, FieldType: Boolean, DefaultValue: True, Description: Enable or disable the back button.
#DesignerProperty: Key: Alignment, DisplayName: Alignment, FieldType: String, DefaultValue: Right, List: Left|Centered|Right
#DesignerProperty: Key: Spacing, DisplayName: Spacing, FieldType: Int, DefaultValue: 2, MinRange: 0, Description: Set spacing between buttons
#DesignerProperty: Key: Margin, DisplayName: Margin, FieldType: Int, DefaultValue: 5, MinRange: 0, Description: Set space between buttons and edges
#DesignerProperty: Key: IconColor, DisplayName: Icons color, FieldType: String, DefaultValue: Auto, List: Auto|Black|White
#DesignerProperty: Key: Color, DisplayName: Color, FieldType: Color, DefaultValue: 0xFFCFDCDC, Description: FunctionBar Color (it's suggested to set the same as notification bar).
#DesignerProperty: Key: Elevation, DisplayName: Elevation, FieldType: Int, DefaultValue: 1, MinRange: 0, Description: Set Function bar's elevation

Sub Class_Globals
	Private mEventName As String 'ignore
	Private mCallBack As Object 'ignore
	Private mBase As Panel
	Private Const DefaultColorConstant As Int = -984833 'ignore
	Dim IP As ImageProcessing
	
	Public ExitBtn As Button
	Public Scroll As HorizontalScrollView
	
	Dim KeyWhite As String
	Dim Margin, Spacing As Int
	Dim Alignment As String
	Dim Back As Boolean
End Sub

Public Sub Initialize (Callback As Object, EventName As String)
	mEventName = EventName
	mCallBack = Callback
End Sub

Public Sub DesignerCreateView (Base As Panel, Lbl As Label, Props As Map)
	mBase = Base
	Dim BColor As Int
	Dim IconColor As String
	BColor = Props.Get("Color")
	Base.Color = BColor
	IconColor = Props.Get("IconColor")
	Margin = Props.Get("Margin")
	Spacing = Props.Get("Spacing")
	Base.Elevation = Props.Get("Elevation")
	Alignment = Props.Get("Alignment")
	Back = Props.Get("Back")
	
	Select IconColor
		Case "White"
			KeyWhite = True
		Case "Black"
			KeyWhite = False
		Case Else
			KeyWhite = (IP.GetRed(BColor) + IP.GetGreen(BColor) + IP.GetBlue(BColor)) < 384
	End Select
	
	If Back Then
		ExitBtn.Initialize("Button") 'Exit button
		ExitBtn.Tag = "Exit"
		SetBtn(ExitBtn, LoadBitmap(File.DirAssets, "icons8-left-96.png"))
		Base.AddView(ExitBtn, Margin, Margin, Base.Height-(Margin*2), Base.Height-(Margin*2))
	End If
End Sub

Public Sub GetBase As Panel
	Return mBase
End Sub

Public Sub CreateButtons(Btns() As String, Icons() As Bitmap)
	Dim Size As Int
	If Icons.Length <  Btns.Length Then
		Size = Icons.Length
	Else
		Size = Btns.Length
	End If
	Dim Start As Int : Start = Margin
	If Back Then
		Start = Start + ExitBtn.Width+Spacing
	End If
	Dim AvailableWidth, RequestedWidth As Int
	AvailableWidth = mBase.Width-Start-Margin
	RequestedWidth = Size * (mBase.Height-2*Margin) + (Size-1)*Spacing
	
	Scroll.Initialize(RequestedWidth, "Functions")
	Dim jo = Scroll As JavaObject
	jo.RunMethod("setHorizontalScrollBarEnabled", Array As Object(False))
	jo.RunMethod("setHorizontalFadingEdgeEnabled", Array As Object(True))
	jo.RunMethod("setOverScrollMode", Array As Object (2))
		
	If RequestedWidth > AvailableWidth Then
		Scroll.FullScroll(True)
		mBase.AddView(Scroll, Start, Margin, AvailableWidth, mBase.Height-(Margin*2))
	Else if Back Then
		Scroll.FullScroll(False)
		mBase.AddView(Scroll, mBase.Width-RequestedWidth-Margin, Margin, RequestedWidth, mBase.Height-(Margin*2))
	Else
		Scroll.FullScroll(False)
		Select Alignment
			Case "Left"
				mBase.AddView(Scroll, Margin, Margin, RequestedWidth, mBase.Height-(Margin*2))
			Case "Centered"
				mBase.AddView(Scroll, (mBase.Width-RequestedWidth)/2, Margin, RequestedWidth, mBase.Height-(Margin*2))
			Case Else
				mBase.AddView(Scroll, mBase.Width-RequestedWidth-Margin, Margin, RequestedWidth, mBase.Height-(Margin*2))
		End Select
	End If
	
	If Back Or Alignment=="Right" Then
		Scroll.ScrollPosition = RequestedWidth
		DoEvents
		Scroll.ScrollPosition = RequestedWidth
	Else if Alignment== "Centered" Then
		Scroll.ScrollPosition = RequestedWidth/2
		DoEvents
		Scroll.ScrollPosition = RequestedWidth/2
	End If
	
	For i=0 To Size-1
		Dim b As Button
		b.Initialize("Button")
		b.Tag = Btns(i)
		SetBtn(b, Icons(i))
		Scroll.Panel.AddView(b, (Scroll.Height+Spacing)*(Size-1-i), 0, Scroll.Height, Scroll.Height)
	Next
End Sub

Sub Button_Click
	Dim btn As Button
	Dim Name As String
   
	btn = Sender
	Name = btn.Tag

	FeedBack(Name)
End Sub

Private Sub FeedBack(Tag As String)
	If SubExists(mCallBack, mEventName & "_ButtonClick") Then
		CallSub2(mCallBack, mEventName & "_ButtonClick", Tag)
	End If
End Sub

Private Sub SetBtn(Btn As Button, icon As Bitmap)
	Dim Default, Pressed As Bitmap
	Dim Bright As Float
	If KeyWhite Then
		Bright = 0.1
	Else
		Bright = -0.4
	End If
	Default = IP.Brightness(IP.Contrast(icon,-1), Bright/Abs(Bright))
	Pressed = IP.Brightness(Default, -Bright)
	Dim Def, Prs As BitmapDrawable
	Def.Initialize(Default)
	Prs.Initialize(Pressed)
	Dim Sld As StateListDrawable
	Sld.Initialize
	Dim states(2) As Int
	states(0)= Sld.State_Enabled
	states(1)= Sld.State_Pressed
	
	Sld.addState2(states, Prs)
	Dim states(1) As Int
	states(0) = Sld.state_enabled
	Sld.addState2(states, Def)
	
	Btn.Background=Sld
End Sub

