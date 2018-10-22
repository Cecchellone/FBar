package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class fbar extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example.fbar");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.fbar.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.PanelWrapper _mbase = null;
public int _defaultcolorconstant = 0;
public jimbrown.imageprocessing.ImageProcessing _ip = null;
public anywheresoftware.b4a.objects.ButtonWrapper _exitbtn = null;
public anywheresoftware.b4a.objects.HorizontalScrollViewWrapper _scroll = null;
public String _keywhite = "";
public int _margin = 0;
public int _spacing = 0;
public String _alignment = "";
public boolean _back = false;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public String  _button_click() throws Exception{
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
String _name = "";
 //BA.debugLineNum = 125;BA.debugLine="Sub Button_Click";
 //BA.debugLineNum = 126;BA.debugLine="Dim btn As Button";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 127;BA.debugLine="Dim Name As String";
_name = "";
 //BA.debugLineNum = 129;BA.debugLine="btn = Sender";
_btn.setObject((android.widget.Button)(__c.Sender(ba)));
 //BA.debugLineNum = 130;BA.debugLine="Name = btn.Tag";
_name = BA.ObjectToString(_btn.getTag());
 //BA.debugLineNum = 132;BA.debugLine="FeedBack(Name)";
_feedback(_name);
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 13;BA.debugLine="Private mEventName As String 'ignore";
_meventname = "";
 //BA.debugLineNum = 14;BA.debugLine="Private mCallBack As Object 'ignore";
_mcallback = new Object();
 //BA.debugLineNum = 15;BA.debugLine="Private mBase As Panel";
_mbase = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private Const DefaultColorConstant As Int = -9848";
_defaultcolorconstant = (int) (-984833);
 //BA.debugLineNum = 17;BA.debugLine="Dim IP As ImageProcessing";
_ip = new jimbrown.imageprocessing.ImageProcessing();
 //BA.debugLineNum = 19;BA.debugLine="Public ExitBtn As Button";
_exitbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Public Scroll As HorizontalScrollView";
_scroll = new anywheresoftware.b4a.objects.HorizontalScrollViewWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Dim KeyWhite As String";
_keywhite = "";
 //BA.debugLineNum = 23;BA.debugLine="Dim Margin, Spacing As Int";
_margin = 0;
_spacing = 0;
 //BA.debugLineNum = 24;BA.debugLine="Dim Alignment As String";
_alignment = "";
 //BA.debugLineNum = 25;BA.debugLine="Dim Back As Boolean";
_back = false;
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return "";
}
public String  _createbuttons(String[] _btns,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper[] _icons) throws Exception{
int _size = 0;
int _start = 0;
int _availablewidth = 0;
int _requestedwidth = 0;
anywheresoftware.b4j.object.JavaObject _jo = null;
int _i = 0;
anywheresoftware.b4a.objects.ButtonWrapper _b = null;
 //BA.debugLineNum = 67;BA.debugLine="Public Sub CreateButtons(Btns() As String, Icons()";
 //BA.debugLineNum = 68;BA.debugLine="Dim Size As Int";
_size = 0;
 //BA.debugLineNum = 69;BA.debugLine="If Icons.Length <  Btns.Length Then";
if (_icons.length<_btns.length) { 
 //BA.debugLineNum = 70;BA.debugLine="Size = Icons.Length";
_size = _icons.length;
 }else {
 //BA.debugLineNum = 72;BA.debugLine="Size = Btns.Length";
_size = _btns.length;
 };
 //BA.debugLineNum = 74;BA.debugLine="Dim Start As Int : Start = Margin";
_start = 0;
 //BA.debugLineNum = 74;BA.debugLine="Dim Start As Int : Start = Margin";
_start = _margin;
 //BA.debugLineNum = 75;BA.debugLine="If Back Then";
if (_back) { 
 //BA.debugLineNum = 76;BA.debugLine="Start = Start + ExitBtn.Width+Spacing";
_start = (int) (_start+_exitbtn.getWidth()+_spacing);
 };
 //BA.debugLineNum = 78;BA.debugLine="Dim AvailableWidth, RequestedWidth As Int";
_availablewidth = 0;
_requestedwidth = 0;
 //BA.debugLineNum = 79;BA.debugLine="AvailableWidth = mBase.Width-Start-Margin";
_availablewidth = (int) (_mbase.getWidth()-_start-_margin);
 //BA.debugLineNum = 80;BA.debugLine="RequestedWidth = Size * (mBase.Height-2*Margin) +";
_requestedwidth = (int) (_size*(_mbase.getHeight()-2*_margin)+(_size-1)*_spacing);
 //BA.debugLineNum = 82;BA.debugLine="Scroll.Initialize(RequestedWidth, \"Functions\")";
_scroll.Initialize(ba,_requestedwidth,"Functions");
 //BA.debugLineNum = 83;BA.debugLine="Dim jo = Scroll As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(_scroll.getObject()));
 //BA.debugLineNum = 84;BA.debugLine="jo.RunMethod(\"setHorizontalScrollBarEnabled\", Arr";
_jo.RunMethod("setHorizontalScrollBarEnabled",new Object[]{(Object)(__c.False)});
 //BA.debugLineNum = 85;BA.debugLine="jo.RunMethod(\"setHorizontalFadingEdgeEnabled\", Ar";
_jo.RunMethod("setHorizontalFadingEdgeEnabled",new Object[]{(Object)(__c.True)});
 //BA.debugLineNum = 86;BA.debugLine="jo.RunMethod(\"setOverScrollMode\", Array As Object";
_jo.RunMethod("setOverScrollMode",new Object[]{(Object)(2)});
 //BA.debugLineNum = 88;BA.debugLine="If RequestedWidth > AvailableWidth Then";
if (_requestedwidth>_availablewidth) { 
 //BA.debugLineNum = 89;BA.debugLine="Scroll.FullScroll(True)";
_scroll.FullScroll(__c.True);
 //BA.debugLineNum = 90;BA.debugLine="mBase.AddView(Scroll, Start, Margin, AvailableWi";
_mbase.AddView((android.view.View)(_scroll.getObject()),_start,_margin,_availablewidth,(int) (_mbase.getHeight()-(_margin*2)));
 }else if(_back) { 
 //BA.debugLineNum = 92;BA.debugLine="Scroll.FullScroll(False)";
_scroll.FullScroll(__c.False);
 //BA.debugLineNum = 93;BA.debugLine="mBase.AddView(Scroll, mBase.Width-RequestedWidth";
_mbase.AddView((android.view.View)(_scroll.getObject()),(int) (_mbase.getWidth()-_requestedwidth-_margin),_margin,_requestedwidth,(int) (_mbase.getHeight()-(_margin*2)));
 }else {
 //BA.debugLineNum = 95;BA.debugLine="Scroll.FullScroll(False)";
_scroll.FullScroll(__c.False);
 //BA.debugLineNum = 96;BA.debugLine="Select Alignment";
switch (BA.switchObjectToInt(_alignment,"Left","Centered")) {
case 0: {
 //BA.debugLineNum = 98;BA.debugLine="mBase.AddView(Scroll, Margin, Margin, Requeste";
_mbase.AddView((android.view.View)(_scroll.getObject()),_margin,_margin,_requestedwidth,(int) (_mbase.getHeight()-(_margin*2)));
 break; }
case 1: {
 //BA.debugLineNum = 100;BA.debugLine="mBase.AddView(Scroll, (mBase.Width-RequestedWi";
_mbase.AddView((android.view.View)(_scroll.getObject()),(int) ((_mbase.getWidth()-_requestedwidth)/(double)2),_margin,_requestedwidth,(int) (_mbase.getHeight()-(_margin*2)));
 break; }
default: {
 //BA.debugLineNum = 102;BA.debugLine="mBase.AddView(Scroll, mBase.Width-RequestedWid";
_mbase.AddView((android.view.View)(_scroll.getObject()),(int) (_mbase.getWidth()-_requestedwidth-_margin),_margin,_requestedwidth,(int) (_mbase.getHeight()-(_margin*2)));
 break; }
}
;
 };
 //BA.debugLineNum = 106;BA.debugLine="If Back Or Alignment==\"Right\" Then";
if (_back || (_alignment).equals("Right")) { 
 //BA.debugLineNum = 107;BA.debugLine="Scroll.ScrollPosition = RequestedWidth";
_scroll.setScrollPosition(_requestedwidth);
 //BA.debugLineNum = 108;BA.debugLine="DoEvents";
__c.DoEvents();
 //BA.debugLineNum = 109;BA.debugLine="Scroll.ScrollPosition = RequestedWidth";
_scroll.setScrollPosition(_requestedwidth);
 }else if((_alignment).equals("Centered")) { 
 //BA.debugLineNum = 111;BA.debugLine="Scroll.ScrollPosition = RequestedWidth/2";
_scroll.setScrollPosition((int) (_requestedwidth/(double)2));
 //BA.debugLineNum = 112;BA.debugLine="DoEvents";
__c.DoEvents();
 //BA.debugLineNum = 113;BA.debugLine="Scroll.ScrollPosition = RequestedWidth/2";
_scroll.setScrollPosition((int) (_requestedwidth/(double)2));
 };
 //BA.debugLineNum = 116;BA.debugLine="For i=0 To Size-1";
{
final int step46 = 1;
final int limit46 = (int) (_size-1);
_i = (int) (0) ;
for (;_i <= limit46 ;_i = _i + step46 ) {
 //BA.debugLineNum = 117;BA.debugLine="Dim b As Button";
_b = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 118;BA.debugLine="b.Initialize(\"Button\")";
_b.Initialize(ba,"Button");
 //BA.debugLineNum = 119;BA.debugLine="b.Tag = Btns(i)";
_b.setTag((Object)(_btns[_i]));
 //BA.debugLineNum = 120;BA.debugLine="SetBtn(b, Icons(i))";
_setbtn(_b,_icons[_i]);
 //BA.debugLineNum = 121;BA.debugLine="Scroll.Panel.AddView(b, (Scroll.Height+Spacing)*";
_scroll.getPanel().AddView((android.view.View)(_b.getObject()),(int) ((_scroll.getHeight()+_spacing)*(_size-1-_i)),(int) (0),_scroll.getHeight(),_scroll.getHeight());
 }
};
 //BA.debugLineNum = 123;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(anywheresoftware.b4a.objects.PanelWrapper _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
int _bcolor = 0;
String _iconcolor = "";
 //BA.debugLineNum = 33;BA.debugLine="Public Sub DesignerCreateView (Base As Panel, Lbl";
 //BA.debugLineNum = 34;BA.debugLine="mBase = Base";
_mbase = _base;
 //BA.debugLineNum = 35;BA.debugLine="Dim BColor As Int";
_bcolor = 0;
 //BA.debugLineNum = 36;BA.debugLine="Dim IconColor As String";
_iconcolor = "";
 //BA.debugLineNum = 37;BA.debugLine="BColor = Props.Get(\"Color\")";
_bcolor = (int)(BA.ObjectToNumber(_props.Get((Object)("Color"))));
 //BA.debugLineNum = 38;BA.debugLine="Base.Color = BColor";
_base.setColor(_bcolor);
 //BA.debugLineNum = 39;BA.debugLine="IconColor = Props.Get(\"IconColor\")";
_iconcolor = BA.ObjectToString(_props.Get((Object)("IconColor")));
 //BA.debugLineNum = 40;BA.debugLine="Margin = Props.Get(\"Margin\")";
_margin = (int)(BA.ObjectToNumber(_props.Get((Object)("Margin"))));
 //BA.debugLineNum = 41;BA.debugLine="Spacing = Props.Get(\"Spacing\")";
_spacing = (int)(BA.ObjectToNumber(_props.Get((Object)("Spacing"))));
 //BA.debugLineNum = 42;BA.debugLine="Base.Elevation = Props.Get(\"Elevation\")";
_base.setElevation((float)(BA.ObjectToNumber(_props.Get((Object)("Elevation")))));
 //BA.debugLineNum = 43;BA.debugLine="Alignment = Props.Get(\"Alignment\")";
_alignment = BA.ObjectToString(_props.Get((Object)("Alignment")));
 //BA.debugLineNum = 44;BA.debugLine="Back = Props.Get(\"Back\")";
_back = BA.ObjectToBoolean(_props.Get((Object)("Back")));
 //BA.debugLineNum = 46;BA.debugLine="Select IconColor";
switch (BA.switchObjectToInt(_iconcolor,"White","Black")) {
case 0: {
 //BA.debugLineNum = 48;BA.debugLine="KeyWhite = True";
_keywhite = BA.ObjectToString(__c.True);
 break; }
case 1: {
 //BA.debugLineNum = 50;BA.debugLine="KeyWhite = False";
_keywhite = BA.ObjectToString(__c.False);
 break; }
default: {
 //BA.debugLineNum = 52;BA.debugLine="KeyWhite = (IP.GetRed(BColor) + IP.GetGreen(BCo";
_keywhite = BA.ObjectToString((_ip.GetRed(_bcolor)+_ip.GetGreen(_bcolor)+_ip.GetBlue(_bcolor))<384);
 break; }
}
;
 //BA.debugLineNum = 55;BA.debugLine="If Back Then";
if (_back) { 
 //BA.debugLineNum = 56;BA.debugLine="ExitBtn.Initialize(\"Button\") 'Exit button";
_exitbtn.Initialize(ba,"Button");
 //BA.debugLineNum = 57;BA.debugLine="ExitBtn.Tag = \"Exit\"";
_exitbtn.setTag((Object)("Exit"));
 //BA.debugLineNum = 58;BA.debugLine="SetBtn(ExitBtn, LoadBitmap(File.DirAssets, \"icon";
_setbtn(_exitbtn,__c.LoadBitmap(__c.File.getDirAssets(),"icons8-left-96.png"));
 //BA.debugLineNum = 59;BA.debugLine="Base.AddView(ExitBtn, Margin, Margin, Base.Heigh";
_base.AddView((android.view.View)(_exitbtn.getObject()),_margin,_margin,(int) (_base.getHeight()-(_margin*2)),(int) (_base.getHeight()-(_margin*2)));
 };
 //BA.debugLineNum = 61;BA.debugLine="End Sub";
return "";
}
public String  _feedback(String _tag) throws Exception{
 //BA.debugLineNum = 135;BA.debugLine="Private Sub FeedBack(Tag As String)";
 //BA.debugLineNum = 136;BA.debugLine="If SubExists(mCallBack, mEventName & \"_ButtonClic";
if (__c.SubExists(ba,_mcallback,_meventname+"_ButtonClick")) { 
 //BA.debugLineNum = 137;BA.debugLine="CallSub2(mCallBack, mEventName & \"_ButtonClick\",";
__c.CallSubNew2(ba,_mcallback,_meventname+"_ButtonClick",(Object)(_tag));
 };
 //BA.debugLineNum = 139;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.PanelWrapper  _getbase() throws Exception{
 //BA.debugLineNum = 63;BA.debugLine="Public Sub GetBase As Panel";
 //BA.debugLineNum = 64;BA.debugLine="Return mBase";
if (true) return _mbase;
 //BA.debugLineNum = 65;BA.debugLine="End Sub";
return null;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 28;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 29;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 30;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return "";
}
public String  _setbtn(anywheresoftware.b4a.objects.ButtonWrapper _btn,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _icon) throws Exception{
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _default = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _pressed = null;
float _bright = 0f;
anywheresoftware.b4a.objects.drawable.BitmapDrawable _def = null;
anywheresoftware.b4a.objects.drawable.BitmapDrawable _prs = null;
anywheresoftware.b4a.objects.drawable.StateListDrawable _sld = null;
int[] _states = null;
 //BA.debugLineNum = 141;BA.debugLine="Private Sub SetBtn(Btn As Button, icon As Bitmap)";
 //BA.debugLineNum = 142;BA.debugLine="Dim Default, Pressed As Bitmap";
_default = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_pressed = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 143;BA.debugLine="Dim Bright As Float";
_bright = 0f;
 //BA.debugLineNum = 144;BA.debugLine="If KeyWhite Then";
if (BA.ObjectToBoolean(_keywhite)) { 
 //BA.debugLineNum = 145;BA.debugLine="Bright = 0.1";
_bright = (float) (0.1);
 }else {
 //BA.debugLineNum = 147;BA.debugLine="Bright = -0.4";
_bright = (float) (-0.4);
 };
 //BA.debugLineNum = 149;BA.debugLine="Default = IP.Brightness(IP.Contrast(icon,-1), Bri";
_default = _ip.Brightness(_ip.Contrast(_icon,(float) (-1)),(float) (_bright/(double)__c.Abs(_bright)));
 //BA.debugLineNum = 150;BA.debugLine="Pressed = IP.Brightness(Default, -Bright)";
_pressed = _ip.Brightness(_default,(float) (-_bright));
 //BA.debugLineNum = 151;BA.debugLine="Dim Def, Prs As BitmapDrawable";
_def = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
_prs = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 152;BA.debugLine="Def.Initialize(Default)";
_def.Initialize((android.graphics.Bitmap)(_default.getObject()));
 //BA.debugLineNum = 153;BA.debugLine="Prs.Initialize(Pressed)";
_prs.Initialize((android.graphics.Bitmap)(_pressed.getObject()));
 //BA.debugLineNum = 154;BA.debugLine="Dim Sld As StateListDrawable";
_sld = new anywheresoftware.b4a.objects.drawable.StateListDrawable();
 //BA.debugLineNum = 155;BA.debugLine="Sld.Initialize";
_sld.Initialize();
 //BA.debugLineNum = 156;BA.debugLine="Dim states(2) As Int";
_states = new int[(int) (2)];
;
 //BA.debugLineNum = 157;BA.debugLine="states(0)= Sld.State_Enabled";
_states[(int) (0)] = _sld.State_Enabled;
 //BA.debugLineNum = 158;BA.debugLine="states(1)= Sld.State_Pressed";
_states[(int) (1)] = _sld.State_Pressed;
 //BA.debugLineNum = 160;BA.debugLine="Sld.addState2(states, Prs)";
_sld.AddState2(_states,(android.graphics.drawable.Drawable)(_prs.getObject()));
 //BA.debugLineNum = 161;BA.debugLine="Dim states(1) As Int";
_states = new int[(int) (1)];
;
 //BA.debugLineNum = 162;BA.debugLine="states(0) = Sld.state_enabled";
_states[(int) (0)] = _sld.State_Enabled;
 //BA.debugLineNum = 163;BA.debugLine="Sld.addState2(states, Def)";
_sld.AddState2(_states,(android.graphics.drawable.Drawable)(_def.getObject()));
 //BA.debugLineNum = 165;BA.debugLine="Btn.Background=Sld";
_btn.setBackground((android.graphics.drawable.Drawable)(_sld.getObject()));
 //BA.debugLineNum = 166;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
