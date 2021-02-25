<template>
	<view class="content cs-display">
		<view class="content-m br-8">
			<view class="one-line cc-display fs-20 ls-8 fw-6 color-primary">公钥</view>
			<view class="more-line cc-display">
				<Textarea class="textarea" v-model="publicKey"></Textarea>
			</view>
			<view style="display:none">
				<input type="file" id="files_publicKey" @change="fnReadFile('publicKey')" />
			</view>
			<view class="one-line cc-display">
				<Button @click="fileLoad('publicKey')">加载</Button>
				<Button @click="fnSave()" style="margin-left:10px">保存</Button>
			</view>

			<view class="line"></view>

			<view class="one-line cc-display fs-20 ls-8 fw-6 color-primary">私钥</view>
			<view class="one-line cc-display fs-18">{{ privateKeyMsg }}</view>
			<view style="display:none">
				<input type="file" id="files_privateKey" @change="fnReadFile('privateKey')" />
			</view>
			<view class="one-line cc-display">
				<Button @click="fileLoad('privateKey')">加载</Button>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		name: "yue",
		props: {
			msg: String,
		},
		data() {
			return {
				privateKeyMsg: "请先加载私钥！",
			};
		},
		computed: {
			publicKey() {
				return this.$store.state.publicKey;
			},
			privateKey() {
				return this.$store.state.privateKey;
			},
		},
		methods: {
			// 公钥保存
			fnSave() {
				console.log(this.$store.state.publicKey);
				uni.request({
					url: this.$baseUrl + 'api/upDateUser', //仅为示例，并非真实接口地址。
					method: 'POST',
					data: {
						userName: this.$store.state.userName,
						publicKey: this.$store.state.publicKey,
					},
					header: {
						'custom-header': 'uni-app-suisei' //自定义请求头信息
					},
					success: (res) => {
						if (res.data.errCode === 'success') {
							uni.showToast({
								title: '公钥保存成功！',
								icon: 'none',
								duration: 2000,
							});
							return;
						}
						uni.showToast({
							title: res.data,
							icon: 'none',
							duration: 2000,
						});
					}
				});
			},

			// 打开文件选择器
			fileLoad(val) {
				this.fnReadFile(val);
			},

			// 文件读取
			fnReadFile(val) {
				const self = this;
				// 请求本地系统文件对象 plus.io.PRIVATE_WWW：应用运行资源目录常量
				plus.io.requestFileSystem(plus.io.PRIVATE_DOC, function(fobject) {
					// fs.root是根目录操作对象DirectoryEntry
					fobject.root.getFile(val + '.txt', {
						create: true
					}, function(fileEntry) {
						fileEntry.file(function(file) {
							var fileReader = new plus.io.FileReader();
							fileReader.readAsText(file, 'utf-8');
							fileReader.onloadend = function(evt) {
								if (val === "publicKey") {
									self.$store.commit("upPublicKey", evt.target.result);
									uni.showToast({
										title: '公钥加载成功！',
										icon: 'success',
										duration: 2000,
									});
								} else {
									self.$store.commit("upPrivateKey", evt.target.result);
									self.privateKeyMsg = "私钥已加载完成！"
									uni.showToast({
										title: '私钥加载成功！',
										icon: 'success',
										duration: 2000,
									});
								}
							}
						});
					});
				});
			},
		},
	};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="less">
	.content {
		width: 100%;
		height: 100%;
		background: url(/static/logo.png) no-repeat top center;

		.content-m {
			padding: 10px 0;
			width: 92.5%;
			background-color: rgba(255, 255, 255, 0.85);

			.one-line {
				height: 60px;
				width: 100%;

				.input {
					height: 40px;
					width: 80%;
				}
			}

			.more-line {
				height: 140px;
				width: 100%;

				.textarea {
					height: 120px;
					width: 100%;
				}
			}
		}
	}

	.line {
		height: 0;
		margin: 20px 0 10px 0;
		border-top: 2px solid #67c23a;
	}
</style>
