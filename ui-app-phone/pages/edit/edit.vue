<template>
	<div class="content cs-display">
		<div class="content-m br-8">
			<div class="one-line cc-display fs-20 ls-8 fw-6 color-primary">
				{{ topTitle }}
			</div>
			<div class="one-line cc-display">
				<LoginInput type="sysname" class="input" v-model="systemName" placeholder="请输入系统/软件名称" />
			</div>
			<div class="one-line cc-display">
				<LoginInput type="accin" class="input" v-model="account" placeholder="请输入账号" />
			</div>
			<div class="one-line cc-display">
				<LoginInput type="passin" class="input" v-model="password" placeholder="请输入密码" />
			</div>
			<div class="one-line cc-display">
				<LoginInput type="more" class="input" v-model="extra" placeholder="请输入备注信息" />
			</div>
			<div class="one-line cc-display">
				<Button @click="fnSave">保存</Button>
			</div>
		</div>
	</div>
</template>

<script>
	export default {
		name: "edit",
		props: {
			msg: String,
		},
		data() {
			return {
				topTitle: "",
				systemName: "",
				account: "",
				password: "",
				extra: "",
				id: "",
			};
		},
		onShow() {
			if (this.$store.state.editStatus) {
				this.systemName = this.$store.state.editItem.systemName;
				this.account = this.$store.state.editItem.account;
				this.password = this.$store.state.editItem.password;
				this.extra = this.$store.state.editItem.extra;
				this.id = this.$store.state.editItem.id;
				this.$store.commit('upEditStatus', false);
				this.$store.commit('upEditItem', {});
				this.topTitle = "修改";
				return;
			}
			this.systemName = "";
			this.account = "";
			this.password = "";
			this.extra = "";
			this.id = "";
			this.topTitle = "增加";
		},
		methods: {
			fnSave() {
				
				if (this.$store.state.publicKey === "") {
					uni.showToast({
						title: '未加载公钥！',
						icon: 'none',
						duration: 1500,
					});
					return;
				}
				this.$rsa.setPublicKey(
					"-----BEGIN PUBLIC KEY-----" +
					this.$store.state.publicKey +
					"-----END PUBLIC KEY-----"
				);

				// 保存
				let sendData = {
					userName: this.$store.state.userName,
					systemName: this.$rsa.encrypt(this.systemName),
					account: this.$rsa.encrypt(this.account),
					password: this.$rsa.encrypt(this.password),
					extra: this.$rsa.encrypt(this.extra),
				};
				let sendUrl = "api/insertData";
				if (this.topTitle === "修改") {
					sendData.id = this.id;
					sendUrl = "api/upDateInfo";
				}
				uni.request({
					url: this.$baseUrl + sendUrl,
					method: 'POST',
					data: sendData,
					header: {
						'custom-header': 'uni-app-suisei' //自定义请求头信息
					},
					success: (res) => {
						if (res.data.errCode === 'success') {
							uni.showToast({
								title: '保存成功！',
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
					width: 95%;
				}
			}
		}
	}
</style>
