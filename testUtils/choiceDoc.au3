ControlFocus("�������� �����","","Edit1")
$dir = @ScriptDir
$dir_parent = StringLeft($dir,StringInStr($dir,"\",0,-1)-1)
ControlSetText("�������� �����","","Edit1", $dir_parent & "..\file\sign.docx")
ControlClick("�������� �����","","Button1")