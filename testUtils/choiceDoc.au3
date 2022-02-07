ControlFocus("Выгрузка файла","","Edit1")
$dir = @ScriptDir
$dir_parent = StringLeft($dir,StringInStr($dir,"\",0,-1)-1)
ControlSetText("Выгрузка файла","","Edit1", $dir_parent & "..\file\sign.docx")
ControlClick("Выгрузка файла","","Button1")