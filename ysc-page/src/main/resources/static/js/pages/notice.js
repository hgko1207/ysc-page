const NoticeManager = function() {
	const dataTable = {
		ele: "#noticeTable",
		table: null,
		option: {
			columns: [
				{
					data: null,
					width: "8%",
			    	render: function(data, type, row, meta) {
			    		return meta.row + 1;
			    	}
			    },
			    {
			    	data: "title",
			    	render: function(data, type, row, meta) {
			    		return `<a href="${contextPath}/notice/detail/${row.id}" ` +
			    		 `class="text-dark">${row.title}</a>`;
			    	}
			    },
			    { 
			    	width: "1%",
			    	data: null,
			    	render: function(data, type, row, meta) {
			    		if (row.files.length > 0) {
			    			return `<img src="${contextPath}/images/small/file.gif"/>`;
			    		} else {
			    			return "";
			    		}
			    	}
		    	},
				{ 
		    		data: "userName",
		    		render: function(data, type, row, meta) {
			    		return `<img src="${contextPath}/images/small/user.gif" class="mr-2"/>${row.userName}`;
			    	}
		    	},
				{
					data: "createDate",
			    	render: function(data, type, row, meta) {
			    		return moment(new Date(row.createDate)).format("YYYY-MM-DD");
			    	}
			    },
			    { 
			    	width: "10%",
			    	data: "hit" 
	    		},
			]
		},
		init: function() {
			this.table = Datatables.notice(this.ele, this.option, 3);
			this.search();
		},
		search: function() {
			const param = new Object();
			Datatables.rowsAdd(this.table, contextPath + "/notice/search", param);
		}
	}
	
	return {
		init: function() {
			dataTable.init();
		}
	}
}();

$(document).ready(function() {
	NoticeManager.init();
});
