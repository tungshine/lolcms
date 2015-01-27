/**
 * 
 */
$(function() {
	
	
	alert(getPager());
	$('#test').datagrid({
	    url:'user/getUserListAjax.json',
	    columns:[[
	        {field:'userId',title:'编号',width:100},
	        {field:'userName',title:'姓名',width:100},
	        {field:'email',title:'邮箱',width:100},
	        {field:'telphone',title:'联系方式',width:100}
	    ]]
	});
	$('#test').datagrid('load',{
		page: 2,
		rows: 10
	});
});



var url;

function newUser() {
	$('#dlg').dialog('open').dialog('setTitle', 'New User');
	$('#fm').form('clear');
	url = 'save_user.php';
}
function editUser() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$('#dlg').dialog('open').dialog('setTitle', 'Edit User');
		$('#fm').form('load', row);
		url = 'update_user.php?id=' + row.id;
	}
}
function saveUser() {
	$('#fm').form('submit', {
		url : url,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			var result = eval('(' + result + ')');
			if (result.errorMsg) {
				$.messager.show({
					title : 'Error',
					msg : result.errorMsg
				});
			} else {
				$('#dlg').dialog('close'); // close the dialog
				$('#dg').datagrid('reload'); // reload the user data
			}
		}
	});
}
function destroyUser() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('Confirm', '是否删除该用户?', function(r) {
			if (r) {
				$.post('user/deleteUser.json', {
					userId : row.userId
				}, function(result) {
					if (result.success) {
						$('#dg').datagrid('reload'); // reload the user data
					} else {
						$.messager.show({ // show error message
							title : 'Error',
							msg : result.errorMsg
						});
					}
				}, 'json');
			}
		});
	}
}