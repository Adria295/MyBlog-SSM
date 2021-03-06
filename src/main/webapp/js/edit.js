$(function () {

	/**
	 * 初始化 SweetAlert2
	 */
	var Toast = Swal.mixin({
		toast: true,
		position: 'top-end',
		showConfirmButton: false,
		timer: 2000
	});

	/**
	 * 初始化 editor.md
	 */
	var blogEditor = editormd("editormd", {
		width: "100%",
		height: 580,
		htmlDecode: true,
		tex: false,
		flowChart:true,
		sequenceDiagram:true,
		imageUpload : true,
		imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
		imageUploadURL : "/upFile",

		// taskList: true,
		toolbarIcons: function () {
			// Using "||" set icons align right.
			return [
				"undo", "redo", "|",
				"bold", "del", "italic", "quote", "ucwords", "uppercase", "lowercase", "|",
				"h1", "h2", "h3", "h4", "h5", "h6", "|",
				"list-ul", "list-ol", "hr", "|",
				"link", "reference-link", "image", "code", "preformatted-text", "code-block", "table", "datetime","emoji", "html-entities", "pagebreak", "|",
				"goto-line", "watch", "preview", "clear", "search", "|",
				"help"
			];
		},
		path: './plugins/editor.md/lib/',
		disabledKeyMaps: [
			"F11"  // disable some default keyboard shortcuts handle
		],
		onload: function () {
			var keyMap = {
				"Ctrl-S": function (cm) {
					$('#isPublish').val(false);
					if (validateBlogForm()) {
						$.ajax({
							url: '',
							type: 'POST',
							data: $('#blogForm').serialize(),
							dataType: 'json',
							success: function (data) {

							},
							error: function (error) {

							}
						});
					}
				},
			};
			this.addKeyMap(keyMap);
		}
	});

	/**
	 * 判断字符串是否为空
	 * @param str
	 * @returns {boolean}
	 */
	function isNull(str) {
		return str === null || str === undefined || str.trim() === '';
	}

	/**
	 * 校验博客表单，标题、分类、描述、内容、有密码时密码不能为空
	 * @returns {boolean}
	 */
	function validateBlogForm() {
		var blogTitle = $('#title').val();
		var blogSlug = $('#slug').val();
		var blogCategoryId = $('#categoryId').val();
		var blogDescription = $('#description').val();
		var blogContent = blogEditor.getMarkdown();
		var blogPassword = $('#contentsstatus').val();

		if (blogPassword=='password' && isNull($('#contentspassword').val())) {
			Toast.fire({
				icon: 'error',
				title: '你要设置啥密码？'
			});
			$('#contentspassword').focus();
			return false;
		}

		if (isNull(blogTitle)) {
			Toast.fire({
				icon: 'error',
				title: '请填写标题哦'
			});
			$('#title').focus();
			return false;
		}

		if (isNull(blogSlug)) {
			Toast.fire({
				icon: 'error',
				title: '请填写缩略名'
			});
			$('#slug').focus();
			return false;
		}

		// if (isNull(blogCategoryId)) {
		// 	Toast.fire({
		// 		icon: 'error',
		// 		title: '请选择分类'
		// 	});
		// 	$('#categoryId').focus();
		// 	return false;
		// }

		if (isNull(blogDescription)) {
			Toast.fire({
				icon: 'error',
				title: '请写一段描述'
			});
			$('#description').focus();
			return false;
		}

		if (isNull(blogContent)) {
			Toast.fire({
				icon: 'error',
				title: '你想写点什么吗'
			});
			blogEditor.focus();
			return false;
		}
		return true;
	}

	/**
	 * 发布按钮事件
	 */
	$('#publishBtn').on('click', function () {
		if (validateBlogForm()) {
			$('#isPublish').val(true);
			$('#blogForm').submit();
		}
		return false;
	});

});